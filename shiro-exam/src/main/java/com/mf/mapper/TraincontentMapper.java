package com.mf.mapper;

import com.mf.domain.Traincontent;

public interface TraincontentMapper {
    int deleteByPrimaryKey(Integer documentid);

    int insert(Traincontent record);

    int insertSelective(Traincontent record);

    Traincontent selectByPrimaryKey(Integer documentid);

    int updateByPrimaryKeySelective(Traincontent record);

    int updateByPrimaryKey(Traincontent record);
}