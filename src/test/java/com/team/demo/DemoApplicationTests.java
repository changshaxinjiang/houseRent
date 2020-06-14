package com.team.demo;

import com.team.demo.entity.DistrictExample;
import com.team.demo.entity.Users;
import com.team.demo.mapper.DistrictMapper;
import com.team.demo.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
   @Autowired
   private DistrictMapper districtMapper;
   @Autowired
   private UsersService usersService;
    @Test
    public void contextLoads() {

       System.out.println("测试:" +districtMapper.selectByExample(new DistrictExample()).size());
        System.out.println("*********************");
        Users user=new Users();
        user.setName("example");
        user.setPassword("123456");
        final int i = usersService.regUser(user);
        System.out.println("插入"+i);

    }

}
