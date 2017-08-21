package com.mf.mapper;

import com.mf.domain.Onlineexamanswerinfor;
import com.mf.domain.OnlineexamanswerinforKey;

public interface OnlineexamanswerinforMapper {
    int deleteByPrimaryKey(OnlineexamanswerinforKey key);

    int insert(Onlineexamanswerinfor record);

    int insertSelective(Onlineexamanswerinfor record);

    Onlineexamanswerinfor selectByPrimaryKey(OnlineexamanswerinforKey key);

    int updateByPrimaryKeySelective(Onlineexamanswerinfor record);

    int updateByPrimaryKey(Onlineexamanswerinfor record);
}