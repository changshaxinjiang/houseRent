package com.team.demo.service.impl;

import com.team.demo.entity.Type;
import com.team.demo.entity.TypeExample;
import com.team.demo.mapper.TypeMapper;
import com.team.demo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired(required = false)
    private TypeMapper typeMapper;
    @Override
    public List<Type> getAllTypes() {
        final List<Type> types = typeMapper.selectByExample(new TypeExample());
        return types;
    }
}
