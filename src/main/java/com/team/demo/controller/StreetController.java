package com.team.demo.controller;

import com.team.demo.entity.Street;
import com.team.demo.entity.StreetExample;
import com.team.demo.service.StreetService;
import com.team.demo.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/street")
@CrossOrigin(value = "*",allowCredentials = "true")
public class StreetController {
    @Autowired
    private StreetService streetService;
    @RequestMapping("/getStreetByDistrictId")
    public BaseResult getStreetByDistrictId(Integer id){
         StreetExample streetExample = new StreetExample();
         StreetExample.Criteria criteria = streetExample.createCriteria();
         StreetExample.Criteria criteria1 = criteria.andDistrictIdEqualTo(id);
        final List<Street> streets = streetService.selectByDistrictId(streetExample);

        return new BaseResult(200,streets);
    }
}
