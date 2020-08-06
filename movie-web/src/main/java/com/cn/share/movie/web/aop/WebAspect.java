package com.cn.share.movie.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class WebAspect {

    // 定义切入点  *通过@Pointcut注解声明频繁使用的切点表达式jetbrains://idea/navigate/reference?project=ShareMovie&fqn=com.cn.share.movie.web.controller
    @Pointcut("execution(public * com.cn.share.movie.web.controller.RedisLockController.*(..)))")
    public void WebAspect(){

    }

    //  在连接点执行之前执行的通知
    @Before("WebAspect()")
    public void beforeWebAspect(){
        log.info("before web aspect");
    }

    //  在连接点执行之后执行的通知
    @After("WebAspect()")
    public void afterWebAspect(){
        log.info("after web aspect");
    }

    //  在连接点执行之后执行的通知（返回通知）
    @AfterReturning("WebAspect()")
    public void afterReturningWebAspect(){
        log.info("AfterReturning web aspect");
    }

    //  连接点执行之后执行的通知（异常通知）
    @AfterThrowing("WebAspect()")
    public void afterThrowingWebAspect(){
        log.info("AfterThrowing web aspect");
    }
}
