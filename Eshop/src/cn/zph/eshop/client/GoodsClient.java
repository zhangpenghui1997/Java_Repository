package cn.zph.eshop.client;

import cn.zph.eshop.common.entity.Msg;
import cn.zph.eshop.common.util.JSONUtil;
import cn.zph.eshop.goods.action.GoodsAction;
import cn.zph.eshop.goods.entity.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsClient extends Client {

    Map<String, Goods> code2Goods = new HashMap<>();

    /***
     * 商品管理首页
     * 商品管理跳转控制器：
     * 本模块的操作由此方法控制跳转
     * 其他模块返回上层，由Client控制跳转
     * @return 返回公共操作
     *
     */
    public String index() {
        showGoodsList();//展示商品列表
        String result = userOperate("请根据序号查看商品详情", "L登录；", "I首页；");
        while (true) {

            if (result.equals(LOGIN)) {
                return LOGIN;
            }
            if (result.equals(EXIT)) {
                return EXIT;
            }
            if (result.equals(INDEX)) {
                return INDEX;
            }
            Goods goods = code2Goods.get(result);//get方法返回结果或者null
            if (goods != null) {
                currentGoods = goods;
                showGoodsDetail();
                result = userOperate("输入A加入购物车", "L登录；", "I首页；");
            } else if (result.equals(ADD)) {//加入购物车
                return ADD;
            } else {
                System.out.println("非法输入请重新输入");
                result = userOperate("请根据序号查看商品详情", "L登录；", "I首页；");
            }
        }

    }

    /**
     * 展示商品列表
     * 1.向后台发送请求，获取商品数量
     * <p>
     * 2.解析响应消息字符串
     * <p>
     * 3.展示商品列表
     */
    public void showGoodsList() {
        //1.向后台发送请求，获取商品属性
        GoodsAction goodsAction = new GoodsAction();
        String msgJSON = goodsAction.getGoodsList();
        //2.解析响应消息字符串
        Msg msg = (Msg) JSONUtil.JSON2Entity(msgJSON, Msg.class);
        Object obj = msg.getObj();
        //数据存放在obj对象里[{},{},{}]
        System.out.println("【商品列表】");
        System.out.println("编号\t\t名称\t\t品牌\t\t库存\t\t单价");
        System.out.println("--------------------------------------------------------------");
        List<?> goodsListJson = (List<?>) obj;
        for (int i = 0; i < goodsListJson.size(); ++i) {
            String goodsJSON = goodsListJson.get(i).toString();
            Goods goods = (Goods) JSONUtil.JSON2Entity(goodsJSON, Goods.class);
            //3.展示商品列表
            String name = goods.getName();
            String brand = goods.getBrand();
            String number = goods.getNumber() + "";
            String price = goods.getPrice() + "";
            System.out.println((i + 1) + ".\t\t" + name + "\t\t\t" + brand + "\t\t\t" + number + "\t\t\t" + price);
            code2Goods.put((i + 1) + "", goods);//存储K:编号；V:商品的对象

        }


    }


    /*查看商品详情
     * 1.通过ID获取数据，然后进行展示
     * 2.在展示商品的时候，把商品列表存储起来；然后选择商品编号*/
    public void showGoodsDetail() {
        System.out.println("【商品详情】");
        System.out.println("名称\t\t品牌\t\t库存\t\t单价");
        System.out.println("--------------------------------------------------------------");
        String name = currentGoods.getName();
        String brand = currentGoods.getBrand();
        String number = currentGoods.getNumber() + "";
        String price = currentGoods.getPrice() + "";
        System.out.println(name + "\t\t\t" + brand + "\t\t\t" + number + "\t\t\t" + price);


    }
}
