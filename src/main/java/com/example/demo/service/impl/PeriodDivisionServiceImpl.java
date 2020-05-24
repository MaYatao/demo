package com.example.demo.service.impl;

import com.example.demo.bean.PreUser;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.mapper.DoctorMapper;
import com.example.demo.mapper.PeriodDivisionMapper;
import com.example.demo.bean.PeriodDivision;
import com.example.demo.mapper.PreUserMapper;
import com.example.demo.pojo.PeriodDivisionResult;
import com.example.demo.service.PeriodDivisionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeriodDivisionServiceImpl implements PeriodDivisionService {

    @Autowired
    private PeriodDivisionMapper periodDivisionMapper;
    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public PeriodDivisionResult getById(Integer pdId) {
        PeriodDivision periodDivision=periodDivisionMapper.selectByPrimaryKey(pdId);
        PeriodDivisionResult periodDivisionResult=new PeriodDivisionResult();
        periodDivisionResult.setDay(periodDivision.getDay());
        periodDivisionResult.setDeptId(periodDivision.getDeptId());
        periodDivisionResult.setDeptName(departmentMapper.selectByPrimaryKey(periodDivision.getDeptId()).getDeptName());
        periodDivisionResult.setDoctId(periodDivision.getDoctId());
        periodDivisionResult.setDoctName(doctorMapper.selectByPrimaryKey(periodDivision.getDoctId()).getDocName());
        periodDivisionResult.setModTime(periodDivision.getModTime());
        periodDivisionResult.setState(periodDivision.getState());
        periodDivisionResult.setTimeDiv(periodDivision.getTimeDiv());
        return periodDivisionResult;
    }

    @Override
    public PageInfo<PeriodDivisionResult> getPDtList(Integer page, Integer row, PeriodDivision periodDivision1) {
        List<PeriodDivision> list = periodDivisionMapper.select(periodDivision1);
        List<PeriodDivisionResult> periodDivisionResultList=new ArrayList<>();
        for (PeriodDivision periodDivision:list){
            PeriodDivisionResult periodDivisionResult=new PeriodDivisionResult();
            periodDivisionResult.setDay(periodDivision.getDay());
            periodDivisionResult.setDeptId(periodDivision.getDeptId());
            periodDivisionResult.setDeptName(departmentMapper.selectByPrimaryKey(periodDivision.getDeptId()).getDeptName());
            periodDivisionResult.setDoctId(periodDivision.getDoctId());
            periodDivisionResult.setDoctName(doctorMapper.selectByPrimaryKey(periodDivision.getDoctId()).getDocName());
            periodDivisionResult.setModTime(periodDivision.getModTime());
            periodDivisionResult.setState(periodDivision.getState());
            periodDivisionResult.setTimeDiv(periodDivision.getTimeDiv());
            periodDivisionResultList.add(periodDivisionResult);
        }
        PageHelper.startPage(page, row);
        PageInfo<PeriodDivisionResult> pages = new PageInfo<PeriodDivisionResult>(periodDivisionResultList);

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
