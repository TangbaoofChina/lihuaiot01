package com.system.security.controller;

import com.system.po.RoleInfo;
import com.system.po.Userlogin;
import com.system.security.realms.MdPasswordUtil;
import com.system.security.util.DESUtil;
import com.system.service.RoleInfoService;
import com.system.service.UserloginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 页面重定向
 *
 * @author ken
 * @since 2017/2/27.
 */
@RequestMapping("/")
@Controller
public class PageForwardHandler {

    @Autowired
    private UserloginService userloginService;
    @Autowired
    private RoleInfoService roleInfoService;

    /**
     * 内部重定向到登陆页面
     *
     * @return 跳转的 jsp
     */
    @RequestMapping("login")
    public String loginPageForward() {
        // 判断当前用户是否已经登陆
        Subject currentSubject = SecurityUtils.getSubject();
        if (!currentSubject.isAuthenticated())
            return "login";
        else
            return "mainpage";
    }

    /**
     * 内部重定向到主页面
     *
     * @return 跳转的 jsp
     */
    @RequestMapping("")
    public String showLoginView() {
        return "mainpage";
    }

    /**
     * 内部重定向到登陆页面
     *
     * @return 跳转的 jsp
     */
    @RequestMapping(value = "loginOa", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public String loginOa(String username, String userpwd) {
        Userlogin userlogin = null;
        List<RoleInfo> roleInfoList = null;
        try {
            //密码
//            username = "吴华";
            DESUtil desUtil = new DESUtil("12345678");
            String realName = desUtil.decryptStr(username);
            // 获取当前的用户的 Subject
            Subject currentUser = SecurityUtils.getSubject();
            // 判断用户是否已经登陆
            if (currentUser != null && currentUser.isAuthenticated()) {
                // 执行账户注销操作
                currentUser.logout();
            }
            String id = realName;
            String password = userpwd;
            UsernamePasswordToken token = new UsernamePasswordToken(id, password);
            currentUser.login(token);
            return "mainpage";
        } catch (Exception ex) {
            return "login";
        }
    }
}
