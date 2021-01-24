package cn.zph.eshop.goods.dao.impl;

import cn.zph.eshop.common.dao.BaseDAO;
import cn.zph.eshop.common.dao.Impl.BaseDAOImpl;
import cn.zph.eshop.goods.dao.GoodsDAO;
import cn.zph.eshop.goods.entity.Goods;

import java.util.List;

public class GoodsDAOImpl extends BaseDAOImpl implements GoodsDAO {
    @Override
    public List<Goods> getEntityList() throws Exception {
        return dataAccess.getList(Goods.class);
        }
}
