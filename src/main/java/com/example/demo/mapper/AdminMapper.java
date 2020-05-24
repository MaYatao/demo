package com.example.demo.mapper;

import com.example.demo.bean.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface AdminMapper extends Mapper<Admin> {
}
