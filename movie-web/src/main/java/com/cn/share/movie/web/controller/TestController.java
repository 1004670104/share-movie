package com.cn.share.movie.web.controller;

import com.cn.share.movie.web.dao.Test;
import com.cn.share.movie.web.service.TestService;
import com.cn.share.movie.web.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/web")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/test")
    public String testInsert(int i){
        Test test = new Test();
        test.setId(i);
        int insert = testService.insert(test);
        String a = "A";
        String b = "B";
        a.equals(b);
        return String.valueOf(insert);
    }

    @RequestMapping("/redis")
    public String redis(){
        redisUtils.setValue("A", "A");
        return redisUtils.getValue("A");
    }

    private static boolean equals(String a, String b){
        if (a == b){
            return true;
        }

        int aLength = a.length();
        int bLength = b.length();

//        if ()
return true;
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("abcdefg");
        System.out.println(stringBuffer.reverse());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("qwerty");
        System.out.println(stringBuilder.reverse());

        HashMap hashMap = new HashMap();
    }
}
