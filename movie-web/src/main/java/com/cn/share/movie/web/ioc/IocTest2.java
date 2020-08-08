package com.cn.share.movie.web.ioc;

import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

import java.util.stream.Stream;

public class IocTest2 {

    public static void main(String[] args) {
        UserController userController = new UserController();
//        BeanFactory
//        FactoryBean

        // 获取class对象
        Class<? extends UserController> clazz = userController.getClass();
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            // 获取属性是否有注解
            MyAutowried annotation = field.getAnnotation(MyAutowried.class);
            if (annotation != null){
                field.setAccessible(true);
                // 获取当前属性类型
                Class<?> type = field.getType();
                try {
                    Object o = type.newInstance();
                    field.set(userController, o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(userController.getUserService());
    }
}
