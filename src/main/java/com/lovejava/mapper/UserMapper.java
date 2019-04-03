package com.lovejava.mapper;

import com.lovejava.domain.User;
import com.lovejava.domain.UserInfo;
import com.lovejava.domain.UserMistake;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author:tianyao
 * @date:2019-04-02 19:38
 */
public interface UserMapper {
    /**
     *
     * 查找所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 查询一个用户
     * @return
     */
    User findOne();

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    Integer addUser(User user);
    /**
     * 修改用户信息
     */
    Integer updateUser(User user);
    /**
     * 删除一个用户,传两个参数
     */
    Integer deleteUser(Map<String,String> map);
    /**
     * 用户名模糊查询
     */
    List<User> findUsersByLike(String s);
    /**
     * 通过javabean的javabean属性的属性进行查询
     */
    User findUserByVo(UserInfo userInfo);
    /**
     * 建数据库对象查询封装给字段名和属性不能一一对应的javabean
     *
     */
    List<UserMistake> findUserMistake();
}
