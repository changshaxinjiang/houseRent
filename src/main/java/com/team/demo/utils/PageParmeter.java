package com.team.demo.utils;

public class PageParmeter {
    private Integer page=1;
    private Integer pageSize=5;

    public PageParmeter() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
