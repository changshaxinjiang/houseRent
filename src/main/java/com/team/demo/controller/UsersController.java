package com.team.demo.controller;

import com.team.demo.entity.Users;
import com.team.demo.service.UsersService;
import com.team.demo.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(value = "*",allowCredentials = "true")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/regUser")
    public BaseResult regUser(Users user){
        final int i = usersService.regUser(user);
        if(i>0){
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        }else{
            return new BaseResult(BaseResult.RESULT_FAIL,"出错了");
        }
    }

    @RequestMapping("/loginUser")

    public BaseResult loginUser(Users user, HttpSession session){


        final Users users = usersService.loginUser(user);
        session.setAttribute("loginUser",users);
        if(users!=null){
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        }else{
            return new BaseResult(BaseResult.RESULT_FAIL,"出错了");
        }
    }
}
