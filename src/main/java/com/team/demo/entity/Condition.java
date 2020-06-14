package com.team.demo.entity;

import com.team.demo.utils.PageParmeter;

public class Condition extends PageParmeter {
    private String title;  //标题
    private Long startPrice; //开始价格
    private Long endPrice;   //结束价格
    private Integer streetId;  //街道Id
    private Integer typeId;    //类型Id
    private Integer districtId; //区域Id

    public Condition(String title, Long startPrice, Long endPrice, Integer streetId, Integer typeId, Integer districtId) {
        this.title = title;
        this.startPrice = startPrice;
        this.endPrice = endPrice;
        this.streetId = streetId;
        this.typeId = typeId;
        this.districtId = districtId;
    }

    public Condition() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Long startPrice) {
        this.startPrice = startPrice;
    }

    public Long getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Long endPrice) {
        this.endPrice = endPrice;
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }
}
