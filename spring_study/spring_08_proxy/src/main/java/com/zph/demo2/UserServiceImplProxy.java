package com.zph.demo2;

public class UserServiceImplProxy implements UserService {
    UserServiceImpl userService = new UserServiceImpl();
    public void add() {
        log("add");
        userService.add();
    }

    public void delete() {
        log("delete");
        userService.delete();
    }

    public void update() {
        log("update");
        userService.update();
    }

    public void select() {
        log("select");
        userService.select();
    }
    public void log(String msg){
        System.out.println("[debug] 调用了"+msg+"方法");
    }
}
