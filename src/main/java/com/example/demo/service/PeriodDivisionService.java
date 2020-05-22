package com.example.demo.service;

import com.example.demo.pojo.PeriodDivision;
import com.github.pagehelper.PageInfo;

public interface PeriodDivisionService {
    PeriodDivision getById(Integer pdId);

    PageInfo<PeriodDivision> getPDtList(Integer page, Integer row, PeriodDivision periodDivision);

    void edit(PeriodDivision periodDivision);

    void save(PeriodDivision periodDivision);
}
