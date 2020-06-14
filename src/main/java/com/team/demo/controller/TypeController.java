package com.team.demo.controller;

import com.team.demo.entity.Type;
import com.team.demo.service.TypeService;
import com.team.demo.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type/")
@CrossOrigin(value = "*",allowCredentials = "true")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("/getAllType")
    public BaseResult getAllType(){

        final List<Type> allTypes = typeService.getAllTypes();

        return new BaseResult(200,allTypes);
    }
}
