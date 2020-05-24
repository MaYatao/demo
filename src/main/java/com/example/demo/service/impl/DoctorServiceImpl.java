package com.example.demo.service.impl;

import com.example.demo.mapper.DoctorMapper;
import com.example.demo.bean.Doctor;
import com.example.demo.service.DoctorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public void save(Doctor doctor) {
        doctorMapper.insert(doctor);
    }

    @Override
    public void edit(Doctor doctor) {
        doctorMapper.updateByPrimaryKeySelective(doctor);
    }

    @Override
    public Doctor login(Doctor doctor) {
        Doctor u = getUserByName(doctor.getDocName());
        if (u == null) {
            throw new RuntimeException("用户名错误");
        }
        if (!u.getPassword().equals(doctor.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        return u;
    }
    private Doctor getUserByName(String name) {
        Doctor doctor = new Doctor();
        doctor.setDocName(name);
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

