package com.mf.mapper;

import com.mf.domain.Newsrecord;

public interface NewsrecordMapper {
    int deleteByPrimaryKey(String newsid);

    int insert(Newsrecord record);

    int insertSelective(Newsrecord record);

    Newsrecord selectByPrimaryKey(String newsid);

    int updateByPrimaryKeySelective(Newsrecord record);

    int updateByPrimaryKeyWithBLOBs(Newsrecord record);

    int updateByPrimaryKey(Newsrecord record);
}