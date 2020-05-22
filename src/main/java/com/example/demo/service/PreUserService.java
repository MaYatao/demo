package com.example.demo.service;

import com.example.demo.pojo.PreUser;
import com.github.pagehelper.PageInfo;

public interface PreUserService {


    void save(PreUser user);

    void edit(PreUser user);

    PreUser login(PreUser user);

    void deleteById(Integer userId);

    PreUser getById(Integer userId);

    PageInfo<PreUser> getUserList(Integer page, Integer row);
}
