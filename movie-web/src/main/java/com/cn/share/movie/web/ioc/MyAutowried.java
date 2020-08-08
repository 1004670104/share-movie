package com.cn.share.movie.web.ioc;

import java.lang.annotation.*;
// 自定义注解

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Inherited
@Documented
public @interface MyAutowried {

}
