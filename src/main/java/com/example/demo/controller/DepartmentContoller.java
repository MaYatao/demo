package com.example.demo.controller;

import com.example.demo.bean.Department;
import com.example.demo.service.DepartmentService;
import com.example.demo.until.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("dept")
@RestController
public class DepartmentContoller {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public Result save(Department department) {
        try {
            departmentService.save(department);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("添加成功");
    }

    @PostMapping("/edit")
    public Result edit(Department department) {
        try {
            departmentService.edit(department);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("修改成功");
    }

    @RequestMapping(value = "/getDeptList", method = RequestMethod.POST)
    @ResponseBody
    public Result getDeptList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10")Integer row, Department department) {
        try {
            PageInfo<Department> doctorList = departmentService.getDeptList(page, row, department);
            return Result.ok(doctorList);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

    @GetMapping("/get/{deptId}")
    public Result getById(@PathVariable(name = "deptId", required = true) Integer deptId) {
        try {
            Department department = departmentService.getById(deptId);
            return Result.ok(department);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }
}
