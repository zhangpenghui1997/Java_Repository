package com.zph.service;

import com.zph.service.Service;

public class ServiceImpl implements Service {

    public void add() {
        System.out.println("向数据库中添加一条数据");
    }

    public void delete() {
        System.out.println("从数据库中删除一条数据");
    }

    public void update() {
        System.out.println("从数据库中更新一条数据");
    }

    public void select() {
        System.out.println("从数据库中查询一条数据");
    }
}