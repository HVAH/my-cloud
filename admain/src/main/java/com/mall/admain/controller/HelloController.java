package com.mall.admain.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class HelloController {

    private @Resource DiscoveryClient discoveryClient;

    @GetMapping(path = { "/hello" })
    public String hello(
            )throws Exception {
        String s = "hello " + new Date() + "fsafasd";
        String aaa = "fsadfasdfa";
        aaa = "";
        aaa = "fafasdfasdf";
        return s;
    }

    @GetMapping(path = {"/dc"})
    public String method(
            )throws Exception {
        String s = "services: " + discoveryClient.getServices();
        System.out.println(s);
        return s;
    }

}
