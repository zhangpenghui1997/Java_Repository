package com.zph.utils;

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all")  //去除警告
public class IDutils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
    @Test
    public void test(){
        System.out.println(getUUID());
    }
}
