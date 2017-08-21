package com.mf.mapper;

import com.mf.domain.Historypaperquestion;

public interface HistorypaperquestionMapper {
    int deleteByPrimaryKey(String questionid);

    int insert(Historypaperquestion record);

    int insertSelective(Historypaperquestion record);

    Historypaperquestion selectByPrimaryKey(String questionid);

    int updateByPrimaryKeySelective(Historypaperquestion record);

    int updateByPrimaryKey(Historypaperquestion record);
}