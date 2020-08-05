package com.cn.share.movie.web.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisLockServieImpl {

    @Autowired
    private Redisson redisson;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void redisLock1(){
        RLock lockName = redisson.getLock("lockName1");
        try {
            lockName.lock();
            delNumber();
        }finally {
            lockName.unlock();
        }
    }

    public void redisLock2(){
        String s = UUID.randomUUID().toString();
        Boolean result = stringRedisTemplate.opsForValue().setIfAbsent("locaName2", s, 10, TimeUnit.SECONDS);
        if (!result){
            return;
        }
        try {
            delNumber();
        }finally {
            if (null != stringRedisTemplate.opsForValue().get("locaName2") && s.equals(stringRedisTemplate.opsForValue().get("locaName2"))){
                stringRedisTemplate.delete("locaName2");
            }
        }
    }

    private void delNumber(){
        Long number = stringRedisTemplate.opsForValue().decrement("number");
        if (number < 0){
            log.info("number = " + number + ", false");
            return;
        }else {
            log.info("number = " + number + ", success");
        }
    }
}
