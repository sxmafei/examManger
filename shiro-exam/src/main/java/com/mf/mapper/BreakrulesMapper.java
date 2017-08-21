package com.mf.mapper;

import com.mf.domain.Breakrules;

public interface BreakrulesMapper {
    int deleteByPrimaryKey(Integer breakid);

    int insert(Breakrules record);

    int insertSelective(Breakrules record);

    Breakrules selectByPrimaryKey(Integer breakid);

    int updateByPrimaryKeySelective(Breakrules record);

    int updateByPrimaryKey(Breakrules record);
}