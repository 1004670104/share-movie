package com.cn.share.movie.web.controller;

import com.cn.share.movie.web.service.impl.RedisLockServieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisLockController {

    @Autowired
    private RedisLockServieImpl redisLockServieImpl;

    @RequestMapping("redisLock1")
    public String redisLock1(){
        redisLockServieImpl.redisLock1();
        return "success";
    }

    @RequestMapping("redisLock2")
    public String redisLock2(){
        redisLockServieImpl.redisLock2();
        return "success";
    }
}
