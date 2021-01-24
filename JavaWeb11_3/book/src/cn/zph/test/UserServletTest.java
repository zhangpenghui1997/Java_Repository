package cn.zph.test;

import java.lang.reflect.Method;

public class UserServletTest {
    public void login() {
        System.out.println("login() run");
    }

    public void regist() {
        System.out.println("regist() run");
    }

    public void updateUser() {
        System.out.println("updateUser() run");
    }

    public void updateUserPassword() {
        System.out.println("updateUserPassword() run");
    }

    public static void main(String[] args) {
     /*   String action = "login";
        try {
            //获取相应业务方法反射对象
            Method declaredMethod = UserServletTest.class.getDeclaredMethod(action);
            //System.out.println(declaredMethod);
            declaredMethod.invoke(new UserServletTest());//调用目标业务方法
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        test();
    }

    public static void test() {
        try {
            int a = 1 / 0;
            return;
        } catch (Exception e) {
            //e.printStackTrace();

        }finally {
            System.out.println("这是finally方法");
        }

    }
}
