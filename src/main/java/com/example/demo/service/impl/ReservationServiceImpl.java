package com.example.demo.service.impl;

import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.mapper.DoctorMapper;
import com.example.demo.mapper.PreUserMapper;
import com.example.demo.mapper.ReservationMapper;
import com.example.demo.bean.Reservation;
import com.example.demo.pojo.ReservationResult;
import com.example.demo.service.ReservationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private PreUserMapper userMapper;
    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public PageInfo<ReservationResult> getDeptList(Integer page, Integer row, Reservation res) {
        List<Reservation> list = reservationMapper.select(res);
        List<ReservationResult> reservationResults=new ArrayList<>();

        for (Reservation reservation: list) {
            ReservationResult reservationResult=new ReservationResult();
            reservationResult.setDoct_id(reservation.getDoct_id());
            reservationResult.setDoctName(doctorMapper.selectByPrimaryKey(reservation.getDoct_id()).getDocName());
            reservationResult.setEndTime(reservation.getEndTime());
            reservationResult.setOpecraDate(reservation.getOpecraDate());
            reservationResult.setPdId(reservation.getPdId());
            reservationResult.setUserId(reservation.getUserId());
            reservationResult.setRealname(userMapper.selectByPrimaryKey(reservation.getUserId()).getRealName());
            reservationResults.add(reservationResult);
        }
        PageHelper.startPage(page, row);
        PageInfo<ReservationResult> pages = new PageInfo<ReservationResult>(reservationResults);
        return pages;
    }

    @Override
    public ReservationResult getById(Integer resId) {
        Reservation reservation =  reservationMapper.selectByPrimaryKey(resId);
        ReservationResult reservationResult=new ReservationResult();
        reservationResult.setDoct_id(reservation.getDoct_id());
        reservationResult.setDoctName(doctorMapper.selectByPrimaryKey(reservation.getDoct_id()).getDocName());
        reservationResult.setEndTime(reservation.getEndTime());
        reservationResult.setOpecraDate(reservation.getOpecraDate());
        reservationResult.setPdId(reservation.getPdId());
        reservationResult.setUserId(reservation.getUserId());
        reservationResult.setRealname(userMapper.selectByPrimaryKey(reservation.getUserId()).getRealName());
        return reservationResult;
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
