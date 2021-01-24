package cn.zph.eshop.goods.service.impl;

import cn.zph.eshop.goods.dao.GoodsDAO;
import cn.zph.eshop.goods.dao.impl.GoodsDAOImpl;
import cn.zph.eshop.goods.entity.Goods;
import cn.zph.eshop.goods.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDAO goodsDAO;
    public GoodsServiceImpl(){
        goodsDAO=new GoodsDAOImpl();
    }

    @Override
    public List<Goods> getGoodsList() throws Exception {
        return  goodsDAO.getEntityList();
    }

    @Override
    public List<Goods> getGoodsList(String ids) throws Exception {
        return null;
    }

    @Override
    public Goods getGoodsDetail() throws Exception {
        return null;
    }
}
