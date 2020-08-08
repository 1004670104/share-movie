package com.cn.share.movie.web.designPattern.singleTon;

public class LazySingleTon {

    private static volatile LazySingleTon lazySingleTon;

    private LazySingleTon(){}

    public static LazySingleTon getLazySingleTon(){
        if (null == lazySingleTon){
            synchronized (LazySingleTon.class){
                if (null == lazySingleTon){
                    lazySingleTon = new LazySingleTon();
                }
            }
        }
        return lazySingleTon;
    }
}
