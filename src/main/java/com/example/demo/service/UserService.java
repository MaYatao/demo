package com.example.demo.service;

import com.example.demo.bean.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
    void save(User user);

    void edit(User user);

    User login(User user);

    User getById(Integer userId);

    void deleteById(Integer userId);

    PageInfo<User> getUserList(Integer page, Integer row, User user);
}
