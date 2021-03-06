package com.example.demo.controller;

import com.example.demo.bean.Reservation;
import com.example.demo.pojo.ReservationResult;
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

    /**
     *
     * @param page
     * @param row
     * @param reservation  用户id，医生id都可以
     * @return
     */
    @RequestMapping(value = "/getDeptList", method = RequestMethod.POST)
    @ResponseBody
    public Result getDeptList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10")Integer row, Reservation reservation) {
        try {
            PageInfo<ReservationResult> doctorList = reservationService.getDeptList(page, row, reservation);
            return Result.ok(doctorList);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }


    @GetMapping("/get/{resId}")
    public Result getById(@PathVariable(name = "resId", required = true) Integer resId) {
        try {
            ReservationResult reservation = reservationService.getById(resId);
            return Result.ok(reservation);
        } catch (Exception e) {
            return Result.build(500, e.getMessage());
        }
    }



}
