package com.system.exception;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器
 * springmvc提供一个HandlerExceptionResolver接口
 * 只要实现该接口，并配置到spring 容器里，该类就能
 * 成为默认全局异常处理类
 * <p>
 * 全局异常处理器只有一个，配置多个也没用。
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    private static Logger logger = LoggerFactory.getLogger("CustomExceptionResolver");

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView modelAndView = new ModelAndView();
        logger.error("错误消息：" + o.toString());
        logger.error("错误消息：" + e.toString());
        logger.error("错误消息：" + e.getMessage());
        CustomException customException;
        if (e instanceof CustomException) {
            customException = (CustomException) e;
        } else if (e instanceof UnknownAccountException) {
            //用户名错误异常
            modelAndView.addObject("message", "没有该用户");
            modelAndView.setViewName("error/error");
            return modelAndView;
        } else if (e instanceof IncorrectCredentialsException) {
            //用户名错误异常
            modelAndView.addObject("message", "密码错误");
            modelAndView.setViewName("error/error");
            return modelAndView;
        } /*else if (e instanceof DataIntegrityViolationException) {
            if(e.getMessage().indexOf("违反完整约束条件") > 0) {
                modelAndView.addObject("message", "存在关联用户");
                modelAndView.setViewName("error/error");
                return modelAndView;
            }else {
                modelAndView.addObject("message", "操作违反数据库约束条件："+ e.getMessage());
                modelAndView.setViewName("error/error");
                return modelAndView;
            }
        }*/ else {
            customException = new CustomException("未知错误" + e.getMessage());
        }
        //错误信息
        String message = customException.getMessage();

        //错误信息传递和错误页面跳转
        modelAndView.addObject("message", message);
        modelAndView.setViewName("error/error");

        return modelAndView;
    }
}
