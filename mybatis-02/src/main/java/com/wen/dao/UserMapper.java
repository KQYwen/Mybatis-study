package com.wen.dao;

import com.wen.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUserList();

//    方法存在多个参数，所有参数都要使用@Param()
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

}
