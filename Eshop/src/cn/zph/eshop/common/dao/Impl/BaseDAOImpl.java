package cn.zph.eshop.common.dao.Impl;

import cn.zph.eshop.common.dao.BaseDAO;
import cn.zph.eshop.common.dao.IDataAccess;

public class BaseDAOImpl implements BaseDAO {
   protected IDataAccess dataAccess=new TXTDataAccess();

}
