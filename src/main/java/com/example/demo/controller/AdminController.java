package com.example.demo.controller;

import com.example.demo.bean.Admin;
import com.example.demo.service.AdminService;

import com.example.demo.until.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("admin")
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/save")
    public Result save(Admin admin) {

        try {
            adminService.save(admin);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("添加成功");
    }

    @PostMapping("/edit")
    public Result edit(Admin admin) {
        try {
            adminService.edit(admin);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("修改成功");

    }

    @PostMapping("/login")
    public Result login(Admin admin) {
        try {
            Admin u = adminService.login(admin);
            u.setPassword("");
            return Result.build(200, "登陆成功", u);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

    @GetMapping("/get/{adminId}")
    public Result getById(@PathVariable(name = "adminId", required = true) Integer adminId) {
        try {
            Admin u = adminService.getById(adminId);
            return Result.build(200, "查询成功", u);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

    @GetMapping("/delete/{adminId}")
    public Result deleteById(@PathVariable(name = "adminId", required = true) Integer adminId) {
        try {
            adminService.deleteById(adminId);
            return Result.build(200, "删除成功");
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/getAdminList", method = RequestMethod.POST)
    @ResponseBody
    public Result getAdminList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10")Integer row,Admin  admin) {

        try {
            PageInfo<Admin> adminList = adminService.getAdminList(page, row,admin);
            return Result.ok(adminList);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }
}
