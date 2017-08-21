package com.mf.mapper;

import com.mf.domain.Questions;

public interface QuestionsMapper {
    int deleteByPrimaryKey(String questionid);

    int insert(Questions record);

    int insertSelective(Questions record);

    Questions selectByPrimaryKey(String questionid);

    int updateByPrimaryKeySelective(Questions record);

    int updateByPrimaryKeyWithBLOBs(Questions record);

    int updateByPrimaryKey(Questions record);
}