package com.team.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.demo.entity.Condition;
import com.team.demo.entity.House;
import com.team.demo.mapper.HouseMapper;
import com.team.demo.service.HouseService;
import com.team.demo.utils.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired(required = false)
    private HouseMapper houseMapper;
    @Override
    public int insertSelective(House house) {
        final int i = houseMapper.insertSelective(house);
        return i;
    }

    /**
     *
     * @param userid  登录用户id
     * @param pageParmeter  页面和当前页数
     * @return   分页数据
     */
    @Override
    public PageInfo<House> getHouseByUser(Integer userid, PageParmeter pageParmeter) {

        //1，开启分页
        PageHelper.startPage(pageParmeter.getPage(),pageParmeter.getPageSize());

        //2,全部查询
        final List<House> houseByUser = houseMapper.getHouseByUser(userid);

        //3,分页信息
        final PageInfo<House> housePageInfo = new PageInfo<>(houseByUser);
        return housePageInfo;
    }

    /**
     *
     * @param id  house的id
     * @param isdel  house的删除状态码  1表示删除，0表示不删除
     * @return
     */
    @Override
    public int delHouseById(String id, Integer isdel) {
        final House house = new House();
        house.setId(id);
        house.setIsdel(isdel);  //设置状态

        final int i = houseMapper.updateByPrimaryKeySelective(house);
        return i;
    }

    @Override
    public PageInfo<House> searchHouseByCondition(Condition condition) {
        PageHelper.startPage(condition.getPage(),condition.getPageSize());
        final List<House> houseByCondition = houseMapper.getHouseByCondition(condition);
        final PageInfo<House> housePageInfo = new PageInfo<>(houseByCondition);
        return housePageInfo;
    }
}
