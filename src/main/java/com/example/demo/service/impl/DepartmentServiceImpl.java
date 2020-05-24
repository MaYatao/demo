package com.example.demo.service.impl;

import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.bean.Department;
import com.example.demo.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public PageInfo<Department> getDeptList(Integer page, Integer row, Department department) {
        List<Department> list = departmentMapper.select(department);
        PageHelper.startPage(page, row);
        PageInfo<Department> pages = new PageInfo<Department>(list);
        return pages;
    }

    @Override
    public void edit(Department department) {
        departmentMapper.updateByPrimaryKeySelective(department);
    }

    @Override
    public void save(Department department) {
        departmentMapper.insert(department);
    }

    @Override
    public Department getById(Integer deptId) {
        return departmentMapper.selectByPrimaryKey(deptId);
    }
}
