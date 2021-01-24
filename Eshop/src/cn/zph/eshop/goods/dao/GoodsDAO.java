package cn.zph.eshop.goods.dao;

import cn.zph.eshop.goods.entity.Goods;

import java.util.List;

public interface GoodsDAO {
    public List<Goods> getEntityList()throws Exception;

}
