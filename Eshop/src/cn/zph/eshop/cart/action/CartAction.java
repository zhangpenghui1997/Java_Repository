package cn.zph.eshop.cart.action;

import cn.zph.eshop.cart.entity.CartGoods;
import cn.zph.eshop.common.action.BaseAction;
import cn.zph.eshop.common.entity.Msg;
import cn.zph.eshop.common.util.JSONUtil;
import cn.zph.eshop.goods.entity.Goods;
import cn.zph.eshop.goods.service.GoodsService;
import cn.zph.eshop.goods.service.impl.GoodsServiceImpl;

import java.util.*;

public class CartAction extends BaseAction {

    /*购物车对象
     * key:商品ID
     * value:商品数量*/
    protected Goods goods = new Goods();
    Map<String, Integer> cart = new HashMap<>();
    //商品模块的服务层对象
    private GoodsService goodsService;
    public CartAction(){
        goodsService=new GoodsServiceImpl();
    }


    /*
     * 添加购物车
     * 把数据存放在cart中
     * 1.如果购物车中已存在该商品，把数量加1
     * 2.如果不存在，放进去的数字是1*/
    public String addCart() {
        Msg msg = new Msg();
        try {
            Integer num = cart.get(goods.getId());
            if (num != null && num > 0) {
                cart.put(goods.getId(), num + 1);
            } else {
                cart.put(goods.getId(), 1);
            }
            msg.setType(Msg.SUCCESS);
            msg.setMsg("添加购物车成功！");

        } catch (Exception e) {
            msg.setType(Msg.FAIL);
            msg.setMsg("服务器异常");
        }
        return JSONUtil.Entity2JSON(msg);


    }
    /*
     *GoodsClient:
     *   currentGoods肯定是有值的
     *   这里的赋值操作，仅仅是对GoodsClient对象赋值
     *   cartClient里面的属性currentGoods并没有被赋值
     *CartClient:
     *    currentGoods没有值
     *    CartClient在创建对象的时候，currentGoods是null
     *
     *  解决方案：currentGoods用static修饰
     *  两个对象GoodsClient和CartClient共享同一个对象
     * */

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    /**
     * 展示购物车
     * 1.获取购物车所有商品的IDs，并转换成字符串，用逗号隔开
     * 2.通过GoodsService对象获取对应的商品列表
     * 3.将Goods对象转换成CartGoods对象
     * 4.封装到Msg对象并返回
     */

    public String showCart() {
        Msg msg = new Msg();
        try {
            //获取购物车中的所有商品IDs
            String ids = Arrays.toString(cart.keySet().toArray());//[id1,id2,id3]
            List<Goods> goodsList=goodsService.getGoodsList(ids);
            List<CartGoods> cgList=new ArrayList<>();
            for (Goods goods1 : goodsList) {
                CartGoods cg=new CartGoods();
                cg.setId(goods1.getId());
                cg.setGoodsNum(cart.get(goods1.getId()));
                cg.setName(goods1.getName());
                cg.setPrice(goods1.getPrice());
                cgList.add(cg);
            }
            msg.setType(Msg.SUCCESS);
            msg.setObj(cgList);
        }catch (Exception e){
            msg.setType(Msg.FAIL);
            msg.setMsg(e.getMessage());
        }
        return JSONUtil.Entity2JSON(msg);
    }

}
