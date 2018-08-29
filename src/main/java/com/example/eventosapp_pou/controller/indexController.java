package com.example.eventosapp_pou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}

