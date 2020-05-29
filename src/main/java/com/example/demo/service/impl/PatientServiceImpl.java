package com.example.demo.service.impl;


import com.example.demo.bean.Patient;
import com.example.demo.mapper.PatientMapper;
import com.example.demo.service.PatientService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;


    @Override
    public void save(Patient patient) {
        patientMapper.insert(patient);
    }

    @Override
    public void edit(Patient patient) {
        patientMapper.updateByPrimaryKeySelective(patient);
    }



    @Override
    public void deleteById(Integer patientId) {
        patientMapper.deleteByPrimaryKey(patientId);
    }

    @Override
    public Patient getById(Integer patientId) {
        return patientMapper.selectByPrimaryKey(patientId);
    }

    @Override
    public PageInfo<Patient> getPatientList(Integer page, Integer row, Patient patient) {
        List<Patient> list = patientMapper.select(patient);
        PageHelper.startPage(page, row);
        PageInfo<Patient> pages = new PageInfo<Patient>(list);
        return pages;

    }
}
