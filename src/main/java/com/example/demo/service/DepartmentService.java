package com.example.demo.service;

import com.example.demo.pojo.Department;
import com.github.pagehelper.PageInfo;

public interface DepartmentService {

    PageInfo<Department> getDeptList(Integer page, Integer row, Department department);

    void edit(Department department);

    void save(Department department);

    Department getById(Integer deptId);
}
