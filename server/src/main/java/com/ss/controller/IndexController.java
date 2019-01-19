package com.ss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndexController {

    @GetMapping("/index")
    public String index() {

        return "index";
    }

    @GetMapping("/vue_test")
    public String testVueModule() {
        return "test_vue_module";
    }


    @GetMapping("/add")
    public String add() {
        return "add";
    }

}
