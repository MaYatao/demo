package com.example.demo.service;

import com.example.demo.bean.Patient;
import com.github.pagehelper.PageInfo;

public interface PatientService {


    void save(Patient patient);

    void edit(Patient patient);


    void deleteById(Integer patientId);

    Patient getById(Integer patientId);

    PageInfo<Patient> getPatientList(Integer page, Integer row, Patient user);
}
