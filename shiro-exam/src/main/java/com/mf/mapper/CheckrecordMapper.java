package com.mf.mapper;

import com.mf.domain.Checkrecord;

public interface CheckrecordMapper {
    int deleteByPrimaryKey(String checkid);

    int insert(Checkrecord record);

    int insertSelective(Checkrecord record);

    Checkrecord selectByPrimaryKey(String checkid);

    int updateByPrimaryKeySelective(Checkrecord record);

    int updateByPrimaryKey(Checkrecord record);
}