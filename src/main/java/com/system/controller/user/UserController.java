package com.system.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    //  全部实时数据显示
    @RequestMapping("/userpage")
    public String showuserpage() throws Exception {
        return "user/userpage";
    }
}
