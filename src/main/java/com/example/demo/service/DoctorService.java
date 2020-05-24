package com.example.demo.service;


import com.example.demo.bean.Doctor;
import com.github.pagehelper.PageInfo;

public interface DoctorService {

    void save(Doctor doctor);

    void edit(Doctor doctor);

    Doctor login(Doctor doctor);

    Doctor getById(Integer docId);

    void deleteById(Integer docId);

    PageInfo<Doctor> getDoctorList(Integer page, Integer row, Doctor doctor);
}
