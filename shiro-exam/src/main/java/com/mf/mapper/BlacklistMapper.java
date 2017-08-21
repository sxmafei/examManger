package com.mf.mapper;

import com.mf.domain.Blacklist;

public interface BlacklistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blacklist record);

    int insertSelective(Blacklist record);

    Blacklist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blacklist record);

    int updateByPrimaryKey(Blacklist record);
}