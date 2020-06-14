package com.team.demo.service.impl;

import com.team.demo.entity.District;
import com.team.demo.entity.DistrictExample;
import com.team.demo.mapper.DistrictMapper;
import com.team.demo.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired(required = false)
    private DistrictMapper districtMapper;

    @Override
    public List<District> getAllDistrict() {
        final List<District> districts = districtMapper.selectByExample(new DistrictExample());
        return districts;
    }
}
