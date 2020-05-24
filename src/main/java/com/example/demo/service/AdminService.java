package com.example.demo.service;

import com.example.demo.bean.Admin;
import com.github.pagehelper.PageInfo;

public interface AdminService {
    void save(Admin admin);

    void edit(Admin admin);

    Admin login(Admin admin);

    Admin getById(Integer adminId);

    void deleteById(Integer adminId);

    PageInfo<Admin> getAdminList(Integer page, Integer row, Admin admin);
}
