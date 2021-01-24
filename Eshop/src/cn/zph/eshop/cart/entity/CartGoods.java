package cn.zph.eshop.cart.entity;


import cn.zph.eshop.goods.entity.Goods;

public class CartGoods extends Goods {
    private int goodsNum;


    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

}
