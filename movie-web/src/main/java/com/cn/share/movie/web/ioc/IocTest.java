package com.cn.share.movie.web.ioc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IocTest {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        UserController userController = new UserController();
        UserService userService = new UserService();
        System.out.println(userService);
        // 注入 getClass()返回一个数组，数组中包含该类中所有公共类和接口类的对象
        Class<? extends UserController> aClass = userController.getClass();
        // 获取属性  	getDeclaredField()获得某个属性对象
        Field service = aClass.getDeclaredField("userService");
        // 设置访问属性
        service.setAccessible(true);
        // 获取对应的set方法
        String name = service.getName();
        name = name.substring(0,1).toUpperCase() + name.substring(1, name.length());
        String methodName = "set" + name;
        Method method = aClass.getMethod(methodName, UserService.class);
        // 调用setUserService方法
        method.invoke(userController, userService);
        System.out.println(userController.getUserService());

    }
}
