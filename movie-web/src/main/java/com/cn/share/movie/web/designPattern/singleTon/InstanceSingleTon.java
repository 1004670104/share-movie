package com.cn.share.movie.web.designPattern.singleTon;

public class InstanceSingleTon {

    private static class SingleTon{
        private static InstanceSingleTon instanceSingleTon = new InstanceSingleTon();
    }

    private InstanceSingleTon(){}

    public static InstanceSingleTon getInstance(){
        return SingleTon.instanceSingleTon;
    }
}
