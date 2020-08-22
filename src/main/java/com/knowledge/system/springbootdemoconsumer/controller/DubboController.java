package com.knowledge.system.springbootdemoconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.knowledge.system.springbootdemodubboapi.dubbodemo.DemoApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboController {

    @Reference(loadbalance = "roundrobin",timeout = 1,cluster ="failfast",check = false)
    DemoApiService demoApiService;

    @GetMapping("/sayhello")
    public String sayHello(){
        return demoApiService.sayHello(); //我调用这个服务可能失败，如果失败了，我要怎么处理
    }
}
