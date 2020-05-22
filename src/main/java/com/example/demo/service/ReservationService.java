package com.example.demo.service;

import com.example.demo.pojo.Reservation;
import com.github.pagehelper.PageInfo;

public interface ReservationService {
    PageInfo<Reservation> getDeptList(Integer page, Integer row, Reservation reservation);

    Reservation getById(Integer resId);

    void edit(Reservation reservation);

    void save(Reservation reservation);
}
