package com.mf.mapper;

import com.mf.domain.Options;

public interface OptionsMapper {
    int deleteByPrimaryKey(String optionid);

    int insert(Options record);

    int insertSelective(Options record);

    Options selectByPrimaryKey(String optionid);

    int updateByPrimaryKeySelective(Options record);

    int updateByPrimaryKey(Options record);
}