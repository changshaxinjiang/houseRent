package com.team.demo.controller;

import com.team.demo.entity.District;
import com.team.demo.service.DistrictService;
import com.team.demo.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/district")
@CrossOrigin(value = "*",allowCredentials = "true")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @RequestMapping("/getAllDistrict")
    public BaseResult getAllDistrict(){
        final List<District> allDistrict = districtService.getAllDistrict();
        return new BaseResult(200,allDistrict);
    }

}
