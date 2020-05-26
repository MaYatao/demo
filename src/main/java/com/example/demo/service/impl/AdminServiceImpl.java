package com.example.demo.service.impl;


import com.example.demo.bean.Admin;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void save(Admin admin) {
        Admin u = getadminByName(admin.getUsername());
        if (u == null) {
            throw new RuntimeException("用户名重复");
        }
        String md5Password = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());
        admin.setPassword(md5Password);
        adminMapper.insert(admin);
    }

    @Override
    public void edit(Admin admin) {
        adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public Admin login(Admin admin) {
        Admin u = getadminByName(admin.getUsername());
        if (u == null) {
            throw new RuntimeException("用户名错误");
        }
        String md5Password = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());
        if (!u.getPassword().equals(md5Password) ){
            throw new RuntimeException("密码错误");
        }
        return u;
    }

    private Admin getadminByName(String name) {
        Admin admin = new Admin();
        admin.setUsername(name);
        return adminMapper.selectOne(admin);
    }

    @Override
    public void deleteById(Integer adminId) {
        adminMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public Admin getById(Integer adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public PageInfo<Admin> getAdminList(Integer page, Integer row, Admin admin) {
        List<Admin> list = adminMapper.select(admin);
        PageHelper.startPage(page, row);
        PageInfo<Admin> pages = new PageInfo<Admin>(list);
        return pages;

    }
}
