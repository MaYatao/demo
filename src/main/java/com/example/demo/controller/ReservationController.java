package com.example.demo.controller;

import com.example.demo.pojo.Reservation;
import com.example.demo.service.ReservationService;
import com.example.demo.until.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("res")
@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/save")
    public Result save(Reservation reservation) {
        try {
            reservationService.save(reservation);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("修改成功");
    }

    @PostMapping("/edit")
    public Result edit(Reservation reservation) {
        try {
            reservationService.edit(reservation);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
        return Result.ok("修改成功");
    }

    @RequestMapping(value = "/getDeptList", method = RequestMethod.POST)
    @ResponseBody
    public Result getDeptList(Integer page, Integer row, Reservation reservation) {
        try {
            PageInfo<Reservation> doctorList = reservationService.getDeptList(page, row, reservation);
            return Result.ok(doctorList);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }

    @GetMapping("/get/{resId}")
    public Result getById(@PathVariable(name = "resId", required = true) Integer resId) {
        try {
            Reservation reservation = reservationService.getById(resId);
            return Result.ok(reservation);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }


}
