package com.system.security.realms;

import com.system.mapperiot.PeopleInfoMapper;
import com.system.po.PeopleInfo;
import com.system.po.Userlogin;
import com.system.service.UserloginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户的认证与授权
 *
 * @author ken
 * @since 2017/2/26.
 */
public class UserAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private UserloginService userloginService;
    @Autowired
    private PeopleInfoMapper peopleInfoMapper;

    /**
     * 对用户进行角色授权
     *
     * @param principalCollection 用户信息
     * @return 返回用户授权信息
     */
    @SuppressWarnings("unchecked")
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 创建存放用户角色的 Set
        Set<String> roles = new HashSet<>();

        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");

        //通过用户名从数据库获取权限/角色信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (userlogin != null) {
            if (userlogin.getOrgid().equals("002"))
                roles.add("admin");
            else
                roles.add("user");
            info.setRoles(roles);
        }
        return new SimpleAuthorizationInfo(roles);
    }

    /**
     * 对用户进行认证
     *
     * @param authenticationToken 用户凭证
     * @return 返回用户的认证信息
     * @throws AuthenticationException 用户认证异常信息
     */
    @SuppressWarnings("unchecked")
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws
            AuthenticationException {

        String realmName = getName();

        Userlogin userlogin = null;
        List<PeopleInfo> peopleInfoList = null;
        try {
            // 获取用户名对应的用户账户信息
            /*UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;*/
            //用户名
            String username = (String) authenticationToken.getPrincipal();
            //密码
            String password = new String((char[]) authenticationToken.getCredentials());

            /*String principal = usernamePasswordToken.getUsername();*/

            userlogin = userloginService.findByNameLiHua(username);
            peopleInfoList = peopleInfoMapper.selectPeopleByPeopleId(userlogin.getUserid());
            if (peopleInfoList.size() > 0) //如果物联网系统中没有配置
            {
                userlogin.setOrgid(peopleInfoList.get(0).getOrgId());
            } else {
                userlogin = null;
                username = "";
                password = "";
            }

            if (userlogin != null) {
                //获取正式的密码(立华牧业用户表)
                String realPassword = MdPasswordUtil.encodePassword(userlogin.getUserid(), password);
                if (!realPassword.equals(userlogin.getPassword())) {
                    //密码错误
                    password = "";
                } else {
                    Subject currentSubject = SecurityUtils.getSubject();
                    Session session = currentSubject.getSession();
                    // 清除 session 中的 userInfo 密码敏感信息
                    userlogin.setPassword(null);
                    // 设置用户信息到 Session
                    session.setAttribute("userInfo", userlogin);
                }
            }

            // 返回封装的认证信息
            return new SimpleAuthenticationInfo(username, password, realmName);

        } catch (Exception e) {
            throw new AuthenticationException();
        }
    }
}
