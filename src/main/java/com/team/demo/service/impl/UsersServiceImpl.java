package com.team.demo.service.impl;
import com.team.demo.entity.Users;
import com.team.demo.entity.UsersExample;
import com.team.demo.mapper.UsersMapper;
import com.team.demo.service.UsersService;
import com.team.demo.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;
    @Override
    public int regUser(Users user) {
        user.setPassword(MD5Utils.md5Encrypt(user.getPassword()));
         int i = usersMapper.insertSelective(user);
        return i;
    }

    @Override
    public Users loginUser(Users user) {
         UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(user.getName());
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(user.getPassword()));
         List<Users> users = usersMapper.selectByExample(usersExample);
        if(users!=null&&users.size()==1){
            return users.get(0);
        }else{
            return null;
        }
    }
}
