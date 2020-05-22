package com.example.demo.service.impl;

import com.example.demo.mapper.ReservationMapper;
import com.example.demo.pojo.Reservation;
import com.example.demo.service.ReservationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public PageInfo<Reservation> getDeptList(Integer page, Integer row, Reservation reservation) {
        List<Reservation> list = reservationMapper.select(reservation);
        PageHelper.startPage(page, row);
        PageInfo<Reservation> pages = new PageInfo<Reservation>(list);
        return pages;
    }

    @Override
    public Reservation getById(Integer resId) {
        return reservationMapper.selectByPrimaryKey(resId);
    }

    @Override
    public void edit(Reservation reservation) {
        reservationMapper.updateByPrimaryKeySelective(reservation);
    }

    @Override
    public void save(Reservation reservation) {
        reservationMapper.insert(reservation);
    }
}
