package com.mf.mapper;

import com.mf.domain.Onlineexaminfor;

public interface OnlineexaminforMapper {
    int deleteByPrimaryKey(String onlineexamid);

    int insert(Onlineexaminfor record);

    int insertSelective(Onlineexaminfor record);

    Onlineexaminfor selectByPrimaryKey(String onlineexamid);

    int updateByPrimaryKeySelective(Onlineexaminfor record);

    int updateByPrimaryKey(Onlineexaminfor record);
}