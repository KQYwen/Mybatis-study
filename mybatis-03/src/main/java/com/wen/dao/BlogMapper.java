package com.wen.dao;

import com.wen.pojo.Blog;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public interface BlogMapper {
//    插入数据
    int addBlog(Blog blog);

    @Select("select * from blog")
    Blog getBlog(String id);

//    IF 查询
    List<Blog> queryBlogIf(Map map);
}
