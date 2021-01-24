package cn.zph.eshop.user.dao.impl;

import cn.zph.eshop.common.dao.Impl.BaseDAOImpl;
import cn.zph.eshop.user.dao.UserDAO;
import cn.zph.eshop.user.entity.User;

import java.util.List;

public class UserDAOImpl extends BaseDAOImpl implements UserDAO {
    /*
    * 调用IDataAccess获取数据并返回
    * 1.创建IDataAccess 子类TXTDataAccess() ，在其父类里创建对象
    * 2.调用该对象的方法获取所有用户数据并返回
    * List<User> userList=dataAccess.getList(User.class);
    * */
    @Override
    public List<User> getEntityList() throws Exception {
        //调用对象的方法获取所有的用户数据并返回
        return dataAccess.getList(User.class);
    }
}
