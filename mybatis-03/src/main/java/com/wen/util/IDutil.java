package com.wen.util;

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all") //抑制警告
public class IDutil {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IDutil.getId());
    }

}
