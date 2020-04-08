package com.system.security.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.system.po.RoleInfo;
import com.system.po.Userlogin;
import com.system.security.realms.MdPasswordUtil;
import com.system.service.RoleInfoService;
import com.system.service.UserloginService;
import com.system.util.RSAUtil;
import com.system.util.Response;
import com.system.util.ResponseFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;
import java.util.Map;

/**
 * 用户账户请求 Handler
 *
 * @author Ken
 * @since 017/2/26.
 */
@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private UserloginService userloginService;

    private static final String USER_ID = "id";
    private static final String USER_NAME = "userName";
    private static final String USER_PASSWORD = "password";
    private static Logger logger = LoggerFactory.getLogger("AccountHandler");

    @RequestMapping(value = "/beforeLogin", method = {RequestMethod.GET})
    @ResponseBody
    public Object beforeLogin(HttpServletRequest request) throws Exception {
        JSONObject result = new JSONObject();
        KeyPair kp = RSAUtil.generateKeyPair();
        RSAPublicKey pubk = (RSAPublicKey) kp.getPublic();// 生成公钥
        RSAPrivateKey prik = (RSAPrivateKey) kp.getPrivate();// 生成私钥
        String publicKeyExponent = pubk.getPublicExponent().toString(16);// 16进制
        String publicKeyModulus = pubk.getModulus().toString(16);// 16进制
        request.getSession().setAttribute("prik", prik);
        result.put("pubexponent", publicKeyExponent);
        result.put("pubmodules", publicKeyModulus);
        return result;
    }

    /**
     * 登陆账户
     *
     * @param username 账户信息
     * @return 返回一个 Map 对象，其中包含登陆操作的结果
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "login", method = {RequestMethod.POST})
    public
    @ResponseBody
    /*Map<String, Object> login(@RequestBody Map<String, Object> user){*/
    Map<String, Object>  login(String username,String userpwd) throws Exception{
        // 初始化 Response
        Response response = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        String errorMsg = "";

        // 获取当前的用户的 Subject
        Subject currentUser = SecurityUtils.getSubject();

        // 判断用户是否已经登陆
        if (currentUser != null && currentUser.isAuthenticated()) {
            // 执行账户注销操作
            currentUser.logout();
        }
        /*if (currentUser != null && !currentUser.isAuthenticated()) {*/
        String id = username;
        String password = userpwd;
        Session session = currentUser.getSession();

        try {
            //解密-start
            //byte[] en_result = new BigInteger(password, 16).toByteArray();
            byte[] en_result = RSAUtil.hexStringToBytes(password);
            byte[] de_result = RSAUtil.decrypt(RSAUtil.getKeyPair().getPrivate(), en_result);
            StringBuffer sb = new StringBuffer();
            sb.append(new String(de_result));
            String pwd = sb.reverse().toString();
            //解密-end
            /*String id = (String) user.get(USER_ID);
            String password = (String) user.get(USER_PASSWORD);*/
            UsernamePasswordToken token = new UsernamePasswordToken(id, pwd);
            // 执行登陆操作
            currentUser.login(token);

            /* 设置 session 中 userInfo 的其他信息 */
            Userlogin userInfo = (Userlogin) session.getAttribute("userInfo");
            // 设置登陆IP
            userInfo.setAccessIP(session.getHost());
            // 插入登录时间
            userloginService.insertLoginRecord(userInfo, "login", userInfo.getAccessIP());

            // 设置登陆成功响应
            result = Response.RESPONSE_RESULT_SUCCESS;

        } catch (UnknownAccountException e) {
            errorMsg = "unknownAccount";
        } catch (IncorrectCredentialsException e) {
            errorMsg = "incorrectCredentials";
        } catch (AuthenticationException e) {
            errorMsg = "authenticationError";
            e.printStackTrace();
        } catch (Exception e) {
            errorMsg = "ServerError";
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            // 当登陆失败则清除session中的用户信息
            if (result.equals(Response.RESPONSE_RESULT_ERROR)){
                session.setAttribute("userInfo", null);
            }
        }
        /*} else {
            errorMsg = "already login";
        }*/

        // 设置 Response
        response.setResponseResult(result);
        response.setResponseMsg(errorMsg);
        /*Map<String, Object> map = response.generateResponse();
        String jsonString = JSON.toJSONString(response);
        return jsonString;*/
        return response.generateResponse();

        //return JSON.toJSONString(response.generateResponse());
    }


    /**
     * 注销账户
     *
     * @return 返回一个 Map 对象，键值为 result 的内容代表注销操作的结果，值为 success 或 error
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> logout() {
        // 初始化 Response
        Response response = ResponseFactory.newInstance();

        Subject currentSubject = SecurityUtils.getSubject();
        if (currentSubject != null && currentSubject.isAuthenticated()) {
            // 执行账户注销操作
            currentSubject.logout();
            response.setResponseResult(Response.RESPONSE_RESULT_SUCCESS);
        } else {
            response.setResponseResult(Response.RESPONSE_RESULT_ERROR);
            response.setResponseMsg("did not login");
        }

        return response.generateResponse();
    }

}
