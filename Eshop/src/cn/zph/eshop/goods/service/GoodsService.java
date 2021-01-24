package cn.zph.eshop.goods.service;

import cn.zph.eshop.common.service.BaseService;
import cn.zph.eshop.goods.entity.Goods;

import java.util.List;

public interface GoodsService extends BaseService {
    List<Goods> getGoodsList()throws Exception;
    List<Goods> getGoodsList(String ids)throws Exception;
    Goods getGoodsDetail()throws Exception;
}
