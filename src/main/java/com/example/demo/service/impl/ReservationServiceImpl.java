package com.example.demo.service.impl;

import com.example.demo.mapper.*;
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
    private PatientMapper patientMapper;
    @Autowired
    private DoctorMapper doctorMapper;



    @Override
    public PageInfo<ReservationResult> getDeptList(Integer page, Integer row, Reservation res) {
        List<Reservation> list = reservationMapper.select(res);
        List<ReservationResult> reservationResults=new ArrayList<>();

        for (Reservation reservation: list) {
            ReservationResult reservationResult=new ReservationResult();
            reservationResult.setDoctorId(reservation.getDoctorId());
            reservationResult.setDoctName(doctorMapper.selectByPrimaryKey(reservation.getDoctorId()).getName());
            reservationResult.setEndTime(reservation.getEndTime());
            reservationResult.setOpecraDate(reservation.getOpecraDate());
            reservationResult.setPdId(reservation.getPdId());
            reservationResult.setPatientId(reservation.getPatientId());
            reservationResult.setPname(patientMapper.selectByPrimaryKey(reservation.getPatientId()).getName());
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
        reservationResult.setDoctorId(reservation.getDoctorId());
        reservationResult.setDoctName(doctorMapper.selectByPrimaryKey(reservation.getDoctorId()).getName());
        reservationResult.setEndTime(reservation.getEndTime());
        reservationResult.setOpecraDate(reservation.getOpecraDate());
        reservationResult.setPdId(reservation.getPdId());
        reservationResult.setPatientId(reservation.getPatientId());
        reservationResult.setPname(patientMapper.selectByPrimaryKey(reservation.getPatientId()).getName());
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
