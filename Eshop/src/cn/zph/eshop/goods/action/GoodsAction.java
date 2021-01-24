package cn.zph.eshop.goods.action;

import cn.zph.eshop.common.action.BaseAction;
import cn.zph.eshop.common.entity.Msg;
import cn.zph.eshop.common.util.JSONUtil;
import cn.zph.eshop.goods.entity.Goods;
import cn.zph.eshop.goods.service.GoodsService;
import cn.zph.eshop.goods.service.impl.GoodsServiceImpl;

import java.util.List;

public class GoodsAction extends BaseAction {
    /*获取商品列表
     * 1.获取所有商品的列表对象
     * 2.将商品列表转换成字符串并返回
     * 3.异常处理
     * 4.记录日志
     * 5.响应消息到客户端
     * */
    private GoodsService goodsService;
    public GoodsAction(){
       goodsService=new GoodsServiceImpl();
    }
    public String getGoodsList() {
        Msg msg = new Msg();

        try{
            //1.获取商品列表
           List<Goods> goodsList= goodsService.getGoodsList();
            //2.将商品对象列表转换成字符串并返回
           msg.setObj(goodsList);
           msg.setType(Msg.SUCCESS);
           String result=JSONUtil.Entity2JSON(msg);
           //4.记录日志
           log.info("获取商品列表");
           //5.响应消息到客户端
           return result;

        }
        catch (Exception e){
         msg.setType(Msg.FAIL);
         msg.setMsg("获取商品列表失败，服务器异常");
         log.error("获取商品信息失败");
        }


        return JSONUtil.Entity2JSON(msg);
    }

    /*获取商品详情
     * */
    public String getGoodsDetail() {
        Msg msg = new Msg();
        return JSONUtil.Entity2JSON(msg);
    }
}
