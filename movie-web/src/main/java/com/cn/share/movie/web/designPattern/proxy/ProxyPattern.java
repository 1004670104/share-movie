package com.cn.share.movie.web.designPattern.proxy;

interface Subject{
    void request();
}

class RealSubject implements Subject{

    @Override
    public void request() {
        System.out.println("RealSubject");
    }
}

class Proxy implements Subject{

    private RealSubject realSubject;

    public Proxy(){
        this.realSubject = new RealSubject();
    }

    @Override
    public void request() {
        before();
        realSubject.request();
        after();
    }

    public void before(){
        System.out.println("Proxy before");
    }

    public void after(){
        System.out.println("Proxy after");
    }
}
public class ProxyPattern {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
