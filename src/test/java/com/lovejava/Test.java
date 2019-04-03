package com.lovejava;

import com.lovejava.domain.User;
import com.lovejava.domain.UserInfo;
import com.lovejava.domain.UserMistake;
import com.lovejava.mapper.UserMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:tianyao
 * @date:2019-04-02 19:50
 */
public class Test {
    private UserMapper mapper;
    private InputStream is;
    private SqlSession sqlSession;
    @Before//执行单元测试之前执行
    public void before(){
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
            sqlSession = build.openSession();
            mapper = sqlSession.getMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After//执行单元测试之后执行
    public void after(){
        sqlSession.commit();
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSession.close();
    }

    /**
     * 查找所有用户
     */
    @org.junit.Test
    public void findAll() {
        List<User> list = mapper.findAll();
        System.out.println(list);
    }

    /**
     * 查找一个用户
     */
    @org.junit.Test
    public void findOne(){
        User user = mapper.findOne();
        System.out.println(user);
    }
    /**
     * 插入一个用户
     */
    @org.junit.Test
    public void addUser(){
        User user = new User();
        user.setUsername("洋葱");
        user.setBirthday("2017-02-03");
        user.setSex("女");
        user.setAddress("太阳");
        Integer integer = mapper.addUser(user);
        System.out.println(integer);
    }

    /**
     * 修改用户数据
     */
    @org.junit.Test
    public void updateUser(){
        User user = new User();
        user.setId(5);
        user.setUsername("洋葱");
        user.setBirthday("2017-02-03");
        user.setSex("女");
        user.setAddress("向往太阳");
        Integer integer = mapper.updateUser(user);
        System.out.println(integer);
    }
    /**
     * 删除一个用户传入多条数据
     */
    @org.junit.Test
    public void deleteUser(){
        Map<String, String> map = new HashMap<>();
        map.put("username","薪王的化身");
        map.put("address","初始的火炉");
        Integer integer = mapper.deleteUser(map);
        System.out.println(integer);
    }
    /**
     * 模糊查询
     */
    @org.junit.Test
    public void findUsersByLike(){
        String s= "奇";
        List<User> usersByLike = mapper.findUsersByLike(s);
        System.out.println(usersByLike);

    }
    /**
     * 通过vo方式查询一个用户
     */
    @org.junit.Test
    public void findUserByVo(){
        UserInfo userInfo = new UserInfo();
        User user = new User();
        user.setUsername("帕奇");
        userInfo.setUser(user);
        User userByVo = mapper.findUserByVo(userInfo);
        System.out.println(userByVo);

    }

    /**
     * 查询javabean对象属性和字段名不相符合的方法
     */
    @org.junit.Test
    public void findUserMistake(){
        List<UserMistake> list = mapper.findUserMistake();
        System.out.println(list);
    }
}
