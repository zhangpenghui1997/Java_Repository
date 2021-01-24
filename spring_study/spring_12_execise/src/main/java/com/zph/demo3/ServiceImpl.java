package com.zph.demo3;

public class ServiceImpl implements Service{
    public void add() {
        System.out.println("添加了一条数据");
    }

    public void delete() {
        System.out.println("删除了一条数据");
    }

    public void update() {
        System.out.println("更新了一条数据");
    }

    public void query() {
        System.out.println("查询了一条数据");
    }
}
