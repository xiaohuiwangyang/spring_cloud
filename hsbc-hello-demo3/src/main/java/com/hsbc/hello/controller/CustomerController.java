package com.hsbc.hello.controller;

import com.hsbc.hello.service.HelloDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    HelloDemoService helloDemoService;

    @GetMapping(value = "/index")
    public Object getIndex() {
        return helloDemoService.index();
    }

    @GetMapping("/find-user")
    public Object getUser(@RequestParam("name") String name) {

        String name1 = helloDemoService.getName(name);
        return name1;
    }

}
