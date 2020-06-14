package com.team.demo.service.impl;

import com.team.demo.entity.Street;
import com.team.demo.entity.StreetExample;
import com.team.demo.mapper.StreetMapper;
import com.team.demo.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {

    @Autowired(required = false)
    private StreetMapper streetMapper;

    @Override
    public List<Street> selectByDistrictId(StreetExample example) {
        final StreetExample streetExample = new StreetExample();
        final StreetExample.Criteria criteria = streetExample.createCriteria();
        final List<Street> streets = streetMapper.selectByExample(streetExample);
        return streets;
    }
}
