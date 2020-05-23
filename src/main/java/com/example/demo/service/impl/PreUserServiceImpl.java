package com.example.demo.service.impl;


import com.example.demo.mapper.PreUserMapper;
import com.example.demo.pojo.PreUser;
import com.example.demo.service.PreUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreUserServiceImpl implements PreUserService {

    @Autowired
    private PreUserMapper preUserMapper;

    @Override
    public void save(PreUser user) {
        preUserMapper.insert(user);
    }

    @Override
    public void edit(PreUser user) {
        preUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public PreUser login(PreUser user) {
        PreUser u = getUserByName(user.getRealName());
        if (u == null) {
            throw new RuntimeException("用户名错误");
        }
        if (!u.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        return u;
    }

    private PreUser getUserByName(String realName) {
        PreUser user = new PreUser();
        user.setRealName(realName);
        return preUserMapper.selectOne(user);
    }

    @Override
    public void deleteById(Integer userId) {
        preUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public PreUser getById(Integer userId) {
        return preUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public PageInfo<PreUser> getUserList(Integer page, Integer row, PreUser user) {
        List<PreUser> list = preUserMapper.select(user);
        PageHelper.startPage(page, row);
        PageInfo<PreUser> pages = new PageInfo<PreUser>(list);
        return pages;

    }
}
