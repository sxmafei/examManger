package com.mf.mapper;

import com.mf.domain.Historypaperoption;

public interface HistorypaperoptionMapper {
    int deleteByPrimaryKey(String optionid);

    int insert(Historypaperoption record);

    int insertSelective(Historypaperoption record);

    Historypaperoption selectByPrimaryKey(String optionid);

    int updateByPrimaryKeySelective(Historypaperoption record);

    int updateByPrimaryKey(Historypaperoption record);
}