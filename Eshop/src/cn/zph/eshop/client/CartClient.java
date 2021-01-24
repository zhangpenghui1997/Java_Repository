package cn.zph.eshop.client;

import cn.zph.eshop.cart.action.CartAction;
import cn.zph.eshop.cart.entity.CartGoods;
import cn.zph.eshop.common.entity.Msg;
import cn.zph.eshop.common.util.JSONUtil;
import cn.zph.eshop.goods.entity.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartClient extends Client {
    CartAction cartAction = new CartAction();
    Map<Integer, CartGoods> code2Goods;
    private String CartAmount;


    /*
    添加购物车
    把当前正在操作的商品添加到购物车中
    1.把currentGoods对象发送请求到Action中
    2.接收Action响应消息*/

    public String addCart() {
        //1.把currentGoods对象发送请求到Action
        cartAction.setGoods(currentGoods);
        //2.接收Action响应消息
        String msgJson = cartAction.addCart();
        Msg msg = (Msg) JSONUtil.JSON2Entity(msgJson, Msg.class);
        if (msg.getType().equals(Msg.SUCCESS)) {
            System.out.println("添加购物车成功！");
        } else {
            System.out.println(msg.getMsg());
        }
        return userOperate("请选择操作", "I继续浏览", "C购物车", "L登录");
    }

    public String getCartAmount() {
        return CartAmount;
    }

    public void setCartAmount(String cartAmount) {
        CartAmount = cartAmount;
    }

    public String showCart() {
        System.out.println("\n【我的购物车】");
        System.out.println("编号\t商品名称\t\t单价\t\t数量");
        System.out.println("------------------------------------");
        String result = cartAction.showCart();
        Msg msg = (Msg) JSONUtil.JSON2Entity(result, Msg.class);
        List<?> cartGoodsList = (List<?>) msg.getObj();
        int i = 1;//序号
        double sum = 0;//总金额
        code2Goods = new HashMap<>(); //将展示标号和数据ID关联起来
        for (Object o : cartGoodsList) {
            String json = o.toString();
            CartGoods cartGoods = (CartGoods) JSONUtil.JSON2Entity(json, CartGoods.class);
            int num = cartGoods.getGoodsNum();
            String name = cartGoods.getName();
            double price = cartGoods.getPrice();
            System.out.println(i + ".\t" + name + "\t\t\t" + price + "\t\t" + num);
            sum += price * num;
            code2Goods.put(i++, cartGoods);
        }
        this.setCartAmount(sum + "");
        System.out.println("总金额：" + sum);
        return userOperate("根据序号选择操作", "I去凑单", "L登录", "O去结算");
    }
}
