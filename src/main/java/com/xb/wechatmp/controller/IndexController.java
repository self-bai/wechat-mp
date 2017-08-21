package com.xb.wechatmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 2017-08-21 14:20
 **/
@Controller
@RequestMapping("")
public class IndexController {

    @RequestMapping(value = {"/", "/index", "/home"}, method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

}
