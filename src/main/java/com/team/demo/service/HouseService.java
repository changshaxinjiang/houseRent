package com.team.demo.service;

import com.github.pagehelper.PageInfo;
import com.team.demo.entity.Condition;
import com.team.demo.entity.House;
import com.team.demo.utils.PageParmeter;

import java.util.List;

public interface HouseService {
    //新增住房
  public  int insertSelective(House record);

  //查询某用户下的出租房
  public PageInfo<House> getHouseByUser(Integer userid, PageParmeter pageParmeter);

  //逻辑删除出租房信息
    public int delHouseById(String id,Integer isdel);
  //条件查询出租房
  PageInfo<House> searchHouseByCondition(Condition condition);
}
