package com.system.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    //  全部实时数据显示
    @RequestMapping("/mainpage")
    public String showmainpage() throws Exception {
        return "admin/mainpage";
    }
}
