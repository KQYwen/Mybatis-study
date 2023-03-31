package com.wen.dao;

import com.wen.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     *   查询全部用户
     * @return Rs
     */
    List<User> getUserList();

    /**
     * 分页查询
     * @param map
     * @return User
     */
    List<User> getUserLimit(Map<String,Integer> map);

    /**
     * 根据id查询用户
     * @param id
     * @return rs
     */
    User getUserById(int id);

    User getUserById2(Map<String,Object> map);

    /**
     * 增加用户
     * @param user
     * @return count
     */
    int insertUser(User user);

    /**
     * 修改姓名和密码
     * @param user
     * @return i
     */
    int updateUser(User user);

    /**
     * 根据id删除数据
     * @param id
     * @return i
     */
    int deleteUserById(int id);

}
