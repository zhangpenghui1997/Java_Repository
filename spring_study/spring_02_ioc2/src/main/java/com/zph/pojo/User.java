package com.zph.pojo;

public class User {
    private String name;
    public User(String name){
        this.name=name;
        //System.out.println("这是无参数的构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("name="+name);
    }
}
