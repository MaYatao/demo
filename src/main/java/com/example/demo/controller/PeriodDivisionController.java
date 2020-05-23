package com.example.demo.controller;

import com.example.demo.pojo.PeriodDivision;
import com.example.demo.service.PeriodDivisionService;
import com.example.demo.until.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("pd")
@RestController
public class PeriodDivisionController {
    @Autowired
    private PeriodDivisionService periodDivisionService;

    @PostMapping("/save")
    public Result save(PeriodDivision periodDivision) {
        try {
            periodDivisionService.save(periodDivision);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("添加成功");
    }

    @PostMapping("/edit")
    public Result edit(PeriodDivision periodDivision) {
        try {
            periodDivisionService.edit(periodDivision);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("修改成功");
    }

    @RequestMapping(value = "/getPdList", method = RequestMethod.POST)
    @ResponseBody
    public Result getDeptList(Integer page, Integer row, PeriodDivision periodDivision) {
        try {
            PageInfo<PeriodDivision> doctorList = periodDivisionService.getPDtList(page, row, periodDivision);
            return Result.ok(doctorList);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

    @GetMapping("/get/{pdId}")
    public Result getById(@PathVariable(name = "pdId", required = true) Integer pdId) {
        try {
            PeriodDivision periodDivision = periodDivisionService.getById(pdId);
            return Result.ok(periodDivision);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }
}
