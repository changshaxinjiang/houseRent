package com.team.demo.mapper;

import com.github.pagehelper.PageInfo;
import com.team.demo.entity.Condition;
import com.team.demo.entity.House;
import com.team.demo.entity.HouseExample;
import com.team.demo.utils.PageParmeter;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    public List<House> getHouseByUser(Integer userid);

    List<House> getHouseByCondition(Condition condition);
}