package com.example.demo.service;

import com.example.demo.bean.Reservation;
import com.example.demo.pojo.ReservationResult;
import com.github.pagehelper.PageInfo;

public interface ReservationService {
    PageInfo<ReservationResult> getDeptList(Integer page, Integer row, Reservation reservation);

    ReservationResult getById(Integer resId);

    void edit(Reservation reservation);

    void save(Reservation reservation);
}
