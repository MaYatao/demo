package com.example.demo.service.impl;

import com.example.demo.bean.Doctor;
import com.example.demo.mapper.DoctorMapper;
import com.example.demo.service.DoctorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;


    @Override
    public void edit(Doctor doctor) {
        doctorMapper.updateByPrimaryKeySelective(doctor);
    }


    private Doctor getUserByName(String name) {
        Doctor doctor = new Doctor();
        doctor.setName(name);
        return doctorMapper.selectOne(doctor);
    }
    @Override
    public Doctor getById(Integer docId) {
        return doctorMapper.selectByPrimaryKey(docId);
    }

    @Override
    public void deleteById(Integer docId) {
        doctorMapper.deleteByPrimaryKey(docId);
    }

    @Override
    public PageInfo<Doctor> getDoctorList(Integer page, Integer row, Doctor doctor) {
        List<Doctor> list = doctorMapper.select(doctor);
        PageHelper.startPage(page, row);
        PageInfo<Doctor> pages = new PageInfo<Doctor>(list);
        return pages;
    }
}

