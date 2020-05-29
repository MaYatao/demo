package com.example.demo.controller;


import com.example.demo.bean.Patient;
import com.example.demo.bean.User;
import com.example.demo.pojo.UserResult;
import com.example.demo.service.PatientService;
import com.example.demo.service.UserService;
import com.example.demo.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;

@RequestMapping("preuser")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public Result save(UserResult userResult) {
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
    public Result edit(Patient user) {
        try {
            patientService.edit(user);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("修改成功");

    }


    @GetMapping("/get/{userId}")
    public Result getById(@PathVariable(name = "userId", required = true) Integer userId) {
        try {
            Patient u = patientService.getById(userId);
            return Result.build(200, "查询成功", u);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }


}
