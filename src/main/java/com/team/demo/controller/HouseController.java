package com.team.demo.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.github.pagehelper.PageInfo;
import com.team.demo.entity.Condition;
import com.team.demo.entity.House;
import com.team.demo.entity.Users;
import com.team.demo.service.HouseService;
import com.team.demo.utils.BaseResult;
import com.team.demo.utils.FileUploadUtil;
import com.team.demo.utils.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/house")
@CrossOrigin(value = "*",allowCredentials = "true")
public class HouseController {
   @Autowired
   private HouseService houseService;

    @RequestMapping("/addHouse")
    public BaseResult addHouse(House house,
                               @RequestParam(value="pfile",required = false)
                                       MultipartFile pfile,
                               HttpSession session){
        //1,上传文件
        try {
            String path="D://picture";
            final String fileName = FileUploadUtil.upload(pfile, path);
            System.out.println("上传文件成功");
          house.setId(System.currentTimeMillis()+"");
           house.setPath(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //2,信息保存到数据库
        Users loginUser =(Users) session.getAttribute("loginUser");
        System.out.println(loginUser.getName());
        house.setUserId(loginUser.getId());
        int i = houseService.insertSelective(house);

        return new BaseResult(200,i);

    }
    //获取用户的出租房信息
    @RequestMapping("/getHouseByPage")
    public BaseResult getHouseByPage(PageParmeter pageParmeter,HttpSession session){
        Users loginUser =(Users) session.getAttribute("loginUser");
        Integer userid =1002;
        pageParmeter.setPageSize(3);
        final PageInfo<House> houseInfoByPage = houseService.getHouseByUser(userid, pageParmeter);

        return new BaseResult(BaseResult.RESULT_SUCCESS, houseInfoByPage);
    }

    @RequestMapping("/delHouse")
    public BaseResult delHouse(String id){

        final int i = houseService.delHouseById(id, 1);
        if(i>0) {
            return new BaseResult(BaseResult.RESULT_SUCCESS, "");
        }else{
            return new BaseResult(BaseResult.RESULT_FAIL,"删除失败");
        }
    }

//浏览出租房
    @RequestMapping("/searchHouse")
    public BaseResult searchHouse(Condition condition){
        final PageInfo<House> housePageInfo = houseService.searchHouseByCondition(condition);
        //封装数据
        Map<String,Object> map=new HashMap<>();
        map.put("curPage",condition.getPage());
        map.put("totalPage",housePageInfo.getPages());
        map.put("list",housePageInfo.getList());

        return new BaseResult(BaseResult.RESULT_SUCCESS,map);
    }
}
