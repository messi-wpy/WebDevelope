package com.messiwpy.springbootweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("login")
    public String testMethod(){

        return "success";
    }

}
