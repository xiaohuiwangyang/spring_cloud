package com.hsbc.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class HelloDemo2 {
    public static void main(String[] args) {
        SpringApplication.run(HelloDemo2.class,args);
    }
    @GetMapping("")
    public Object index() {
        String str = "这是服务端2返回的应答";
        return new String(str);
    }
}
