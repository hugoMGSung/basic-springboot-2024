package com.hugo83.backboard.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class MainController {
    
    @GetMapping("/hello")
    public String getHello() {
        log.info("getHello(); 실행.");
        return "hello";
    }
    
}
