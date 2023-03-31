package com.wen.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    private String id; //博客id
    private String title; //博客标题
    private String author; //博客作者
    private Date createTime; //创建时间
    private int views; //浏览量
}
