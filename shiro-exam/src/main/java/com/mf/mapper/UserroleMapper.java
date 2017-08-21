package com.mf.mapper;

import com.mf.domain.UserroleKey;

public interface UserroleMapper {
    int deleteByPrimaryKey(UserroleKey key);

    int insert(UserroleKey record);

    int insertSelective(UserroleKey record);
}