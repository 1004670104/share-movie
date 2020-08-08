package com.cn.share.movie.web.designPattern.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface DySubject{
    void request();
}

class DyRealySubject implements DySubject{

    @Override
    public void request() {
        System.out.println("dynamic real project");
    }
}

class DyProxy implements InvocationHandler{

    protected DySubject subject;

    public DyProxy(DySubject dySubject){
        this.subject = dySubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        method.invoke(subject, args);
        System.out.println("after");
        return null;
    }
}

public class DynamicProxy {

    public static void main(String[] args) {
        DySubject dySubject = new DyRealySubject();
        DyProxy dyProxy = new DyProxy(dySubject);
        //newProxyInstance（获得类的加载器，获得当前类实现的类或是接口，当前类）
        DySubject o = (DySubject)Proxy.newProxyInstance(dySubject.getClass().getClassLoader(), dySubject.getClass().getInterfaces(), dyProxy);
        o.request();
    }
}
