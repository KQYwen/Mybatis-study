package com.wen;

import com.wen.dao.UserMapper;
import com.wen.pojo.User;
import com.wen.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

//    static Logger logger=Logger.getLogger(UserMapperTest.class);

    @Test
    public void getUserList(){
        //获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        logger.info("测试，进入getUserById");

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(2);
        System.out.println(userById);

        sqlSession.close();
    }
    @Test
    public void getUserLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userLimit = mapper.getUserLimit(map);
        for (User user : userLimit) {
            System.out.println(user);
        }

        sqlSession.close();

    }
    @Test
    public void insertUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(4);
        user.setName("李轩");
        user.setPwd("030518");
        int i = mapper.insertUser(user);
        for (User user1 : mapper.getUserList()) {
            System.out.println(user1);
        }
        if (i>0){
            System.out.println("插入成功");
        }
        sqlSession.commit(i>0);

        sqlSession.close();
    }
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateUser(new User(2, "老王", "111"));
        if (i>0){
            System.out.println("更新成功");
        }

        sqlSession.commit(i>0);

        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
    @Test
    public void deleteUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUserById(3);

        sqlSession.commit(i>0);
        sqlSession.close();
    }
    @Test
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("userid",2);
        User userById2 = mapper.getUserById2(map);
        System.out.println(userById2);

        sqlSession.close();
    }
}
