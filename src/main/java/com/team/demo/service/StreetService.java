package com.team.demo.service;

import com.team.demo.entity.Street;
import com.team.demo.entity.StreetExample;

import java.util.List;

public interface StreetService {
    public List<Street> selectByDistrictId(StreetExample example);
}
