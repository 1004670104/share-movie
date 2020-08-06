package com.cn.share.movie.web.util;

public class HungarySingleTon {

    private static HungarySingleTon hungarySingleTon = new HungarySingleTon();

    private HungarySingleTon(){ }

    public static HungarySingleTon getHungarySingleTon(){
        return hungarySingleTon;
    }
}
