package com.mf.mapper;

import com.mf.domain.Pictureindex;

public interface PictureindexMapper {
    int deleteByPrimaryKey(String pictureid);

    int insert(Pictureindex record);

    int insertSelective(Pictureindex record);

    Pictureindex selectByPrimaryKey(String pictureid);

    int updateByPrimaryKeySelective(Pictureindex record);

    int updateByPrimaryKey(Pictureindex record);
}