package com.murder.mystery.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by xsw on 2017/10/12.
 */
@Controller
public class URLController {

    @RequestMapping("/")
    public String HelloWord(){
        return "/HelloWord";
    }


}
