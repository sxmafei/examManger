package com.mf.mapper;

import com.mf.domain.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(String projectid);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(String projectid);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}