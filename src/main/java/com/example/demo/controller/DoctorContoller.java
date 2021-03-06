package com.example.demo.controller;

import com.example.demo.bean.Doctor;
import com.example.demo.service.DoctorService;
import com.example.demo.until.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("doctor")
@RestController
public class DoctorContoller {
    @Autowired
    private DoctorService doctorService;

/*    @PostMapping("/save")
    public Result save(Doctor doctor) {
        try {
            doctorService.save(doctor);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("添加成功");
    }*/

    @PostMapping("/edit")
    public Result edit(Doctor doctor) {
        try {
            doctorService.edit(doctor);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("修改成功");

    }


    @GetMapping("/get/{docId}")
    public Result getById(@PathVariable(name = "docId", required = true) Integer docId) {
        try {
            Doctor doctor = doctorService.getById(docId);
            return Result.ok(doctor);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

     @GetMapping("/delete/{docId}")
    public Result deleteById(@PathVariable(name = "docId", required = true) Integer docId) {
        try {
            doctorService.deleteById(docId);
            return Result.build(200, "删除成功");
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/getDoctList", method = RequestMethod.POST)
    @ResponseBody
    public Result getUserList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10")Integer row, Doctor doctor) {
        try {
            PageInfo<Doctor> doctorList = doctorService.getDoctorList(page, row, doctor);
            return Result.ok(doctorList);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

}
