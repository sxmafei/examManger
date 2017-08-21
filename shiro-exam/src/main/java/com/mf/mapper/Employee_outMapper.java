package com.mf.mapper;

import com.mf.domain.Employee_out;

public interface Employee_outMapper {
    int deleteByPrimaryKey(String employeeid);

    int insert(Employee_out record);

    int insertSelective(Employee_out record);

    Employee_out selectByPrimaryKey(String employeeid);

    int updateByPrimaryKeySelective(Employee_out record);

    int updateByPrimaryKey(Employee_out record);
}