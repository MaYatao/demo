package com.example.demo.service.impl;

import com.example.demo.mapper.PeriodDivisionMapper;
import com.example.demo.pojo.PeriodDivision;
import com.example.demo.service.PeriodDivisionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodDivisionServiceImpl implements PeriodDivisionService {

    @Autowired
    private PeriodDivisionMapper periodDivisionMapper;

    @Override
    public PeriodDivision getById(Integer pdId) {
        return periodDivisionMapper.selectByPrimaryKey(pdId);
    }

    @Override
    public PageInfo<PeriodDivision> getPDtList(Integer page, Integer row, PeriodDivision periodDivision) {
        List<PeriodDivision> list = periodDivisionMapper.select(periodDivision);
        PageHelper.startPage(page, row);
        PageInfo<PeriodDivision> pages = new PageInfo<PeriodDivision>(list);
        return pages;
    }

    @Override
    public void edit(PeriodDivision periodDivision) {
        periodDivisionMapper.updateByPrimaryKeySelective(periodDivision);
    }

    @Override
    public void save(PeriodDivision periodDivision) {
        periodDivisionMapper.insert(periodDivision);
    }
}
