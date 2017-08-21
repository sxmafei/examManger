package com.mf.mapper;

import com.mf.domain.Exam;

public interface ExamMapper {
    int deleteByPrimaryKey(String examid);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(String examid);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);
}