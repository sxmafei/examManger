package com.mf.mapper;

import com.mf.domain.Employeeexam;

public interface EmployeeexamMapper {
    int deleteByPrimaryKey(String gradeid);

    int insert(Employeeexam record);

    int insertSelective(Employeeexam record);

    Employeeexam selectByPrimaryKey(String gradeid);

    int updateByPrimaryKeySelective(Employeeexam record);

    int updateByPrimaryKey(Employeeexam record);
}