package com.dev.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public long homeMain() {
        System.out.println(System.currentTimeMillis());
        return System.currentTimeMillis();
    }
}
