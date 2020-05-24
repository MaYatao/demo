package com.example.demo.controller;


import com.example.demo.bean.PreUser;
import com.example.demo.service.PreUserService;
import com.example.demo.until.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("user")
@RestController
public class PreUserController {

    @Autowired
    private PreUserService preUserService;

    @PostMapping("/save")
    public Result save(PreUser user) {
        user.setRegDate(new Date());
        try {
            preUserService.save(user);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("添加成功");
    }

    @PostMapping("/edit")
    public Result edit(PreUser user) {
        try {
            preUserService.edit(user);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("修改成功");

    }

    @PostMapping("/login")
    public Result login(PreUser user) {
        try {
            PreUser u = preUserService.login(user);
            u.setPassword("");
            return Result.build(200, "登陆成功", u);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

    @GetMapping("/get/{userId}")
    public Result getById(@PathVariable(name = "userId", required = true) Integer userId) {
        try {
            PreUser u = preUserService.getById(userId);
            return Result.build(200, "查询成功", u);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

     @GetMapping("/delete/{userId}")
    public Result deleteById(@PathVariable(name = "userId", required = true) Integer userId) {
        try {
            preUserService.deleteById(userId);
            return Result.build(200, "删除成功");
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ResponseBody
    public Result getUserList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10")Integer row,PreUser  user) {

        try {
            PageInfo<PreUser> userList = preUserService.getUserList(page, row,user);
            return Result.ok(userList);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }


}
