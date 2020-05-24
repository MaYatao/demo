package com.example.demo.service;

import com.example.demo.bean.PeriodDivision;
import com.example.demo.pojo.PeriodDivisionResult;
import com.github.pagehelper.PageInfo;

public interface PeriodDivisionService {
    PeriodDivisionResult getById(Integer pdId);

    PageInfo<PeriodDivisionResult> getPDtList(Integer page, Integer row, PeriodDivision periodDivision);

    void edit(PeriodDivision periodDivision);

    void save(PeriodDivision periodDivision);
}
