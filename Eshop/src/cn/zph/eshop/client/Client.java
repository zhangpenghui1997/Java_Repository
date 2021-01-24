package cn.zph.eshop.client;

import cn.zph.eshop.goods.entity.Goods;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*客户端顶层父类
 * 处理公共的用户操作*/
public class Client {
    //用户操作 登录
    public static final String LOGIN = "L";
    //用户操作 上一次操作记录
    public static final String HISTORY = "I";
    //用户操作 首页
    public static final String INDEX = "I";
    //用户操作退出
    public static final String EXIT = "E";

    //用户操作添加购物车
    public static final String ADD = "A";

    //用户操作购物车
    public static final String CART = "C";
    protected Scanner sc = new Scanner(System.in);

    //当前正在操作的商品对象
    protected static Goods currentGoods;

    public static void main(String[] args) throws Exception {
        Client c = new Client();
        c.start();
    }

    /*debug调试
    * 1.在可能出现问题的代码前加上断点
    * 2.以Debug模式运行*/
    public void start() throws Exception {
        GoodsClient goodsClient = new GoodsClient();
        UserClient userClient = new UserClient();
        String result = goodsClient.index();
        CartClient cartClient = new CartClient();

        while (true) {
            if (result.equals(INDEX)) {
                result = goodsClient.index();
            } else if (result.equals(HISTORY)) {
                result = HISTORY;
            } else if (result.equals(LOGIN)) {
                result = userClient.showLogin();
            } else if (result.equals(ADD)) { //添加到购物车
                //进入购物车模块，添加商品到购物车
                cartClient.addCart();

            } else if (result.equals(CART)) { //去购物车
               cartClient.showCart();

            } else if (result.equals(EXIT)) {
                System.exit(0);
            } else {
                System.out.println("出错了");
            }

        }

    }
    /*需求：创建公共的用户操作方法
     * 主要功能
     * 1.提示用户信息和用户操作
     * 2.接受用户的录入 sc.nextLine()
     * 方法分析：
     * 方法名：userOperate
     * 返回值：String
     * 参数列表：String msg;用户信息
     * String... oper;用户操作*/

    public String userOperate(String msg, String... oprs) {
        //oprs==String[]
        String opr = Arrays.toString(oprs);//[opr1,opr2,opr3,...]
        opr = opr.substring(1, opr.length() - 1);
        msg = msg + "(或" + opr + "E退出）：";
        System.out.println(msg);//请根据编号进行操作，（或L登录；E退出）

        return sc.nextLine().trim().toUpperCase();//去掉空格并转成大写
    }
}
