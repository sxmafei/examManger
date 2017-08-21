package com.mf.mapper;

import com.mf.domain.Unit;

public interface UnitMapper {
    int deleteByPrimaryKey(String unitid);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(String unitid);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
}