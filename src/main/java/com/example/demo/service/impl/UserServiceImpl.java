package com.example.demo.service.impl;


import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        User u = getUserByName(user.getUsername());
        if (u == null) {
            throw new RuntimeException("用户名重复");
        }
        String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Password);
        userMapper.insert(user);
    }

    @Override
    public void edit(User user) {
        if (!StringUtils.isEmpty(user.getPassword())) {
            String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            user.setPassword(md5Password);
        }
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User login(User user) {
        User u = getUserByName(user.getUsername());
        if (u == null) {
            throw new RuntimeException("用户名错误");
        }
        String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        if (!u.getPassword().equals(md5Password) ){
            throw new RuntimeException("密码错误");
        }
        return u;
    }

    private User getUserByName(String name) {
        User user = new User();
        user.setUsername(name);
        return userMapper.selectOne(user);
    }

    @Override
    public void deleteById(Integer UserId) {
        userMapper.deleteByPrimaryKey(UserId);
    }

    @Override
    public User getById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public PageInfo<User> getUserList(Integer page, Integer row, User user) {
        List<User> list = userMapper.select(user);
        PageHelper.startPage(page, row);
        PageInfo<User> pages = new PageInfo<User>(list);
        return pages;

    }
}
