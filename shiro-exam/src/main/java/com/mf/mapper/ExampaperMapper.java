package com.mf.mapper;

import com.mf.domain.Exampaper;

public interface ExampaperMapper {
    int deleteByPrimaryKey(String paperid);

    int insert(Exampaper record);

    int insertSelective(Exampaper record);

    Exampaper selectByPrimaryKey(String paperid);

    int updateByPrimaryKeySelective(Exampaper record);

    int updateByPrimaryKey(Exampaper record);
}