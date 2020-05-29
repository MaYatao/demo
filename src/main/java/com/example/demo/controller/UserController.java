package com.example.demo.controller;

import com.example.demo.bean.Patient;
import com.example.demo.bean.User;
import com.example.demo.pojo.UserResult;
import com.example.demo.service.PatientService;
import com.example.demo.service.UserService;
import com.example.demo.until.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;

    @PostMapping("/pre/save")
    public Result presave(UserResult userResult) {
        Date date = new Date();
        DateFormat df1 = DateFormat.getDateInstance();
        userResult.setRegDate(df1.format(date));
        User user=new User();
        user.setName(userResult.getName());
        user.setPassword(userResult.getPassword());
        user.setRoleId(userResult.getRoleId());
        user.setUsername(userResult.getUsername());
        Patient patient =new Patient();
        patient.setAge(userResult.getAge());
        patient.setCard(userResult.getCard());
        patient.setEmail(userResult.getEmail());
        patient.setPhone(userResult.getPhone());
        patient.setRegDate(userResult.getRegDate());
        patient.setState(userResult.getState());
        try {
            userService.save(user);
            patientService.save(patient);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("添加成功");
    }

    @PostMapping("/edit")
    public Result edit(User User) {
        try {
            userService.edit(User);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("修改成功");
    }

    @PostMapping("/login")
    public Result login(User User, HttpSession session) {
        try {
            User u = userService.login(User);
            u.setPassword(null);
            return Result.build(200, "登陆成功", u);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

    @GetMapping("/get/{userId}")
    public Result getById(@PathVariable(name = "userId", required = true) Integer UserId) {
        try {
            User u = userService.getById(UserId);
            return Result.build(200, "查询成功", u);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

    @GetMapping("/delete/{userId}")
    public Result deleteById(@PathVariable(name = "userId", required = true) Integer userId) {
        try {
            userService.deleteById(userId);
            return Result.build(200, "删除成功");
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ResponseBody
    public Result getUserList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10")Integer row,User  user) {

        try {
            PageInfo<User> UserList = userService.getUserList(page, row,user);
            return Result.ok(UserList);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }
}
