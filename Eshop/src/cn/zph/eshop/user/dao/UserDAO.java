package cn.zph.eshop.user.dao;

import cn.zph.eshop.common.dao.BaseDAO;
import cn.zph.eshop.user.entity.User;

import java.util.List;

public interface UserDAO extends BaseDAO {
    List<User> getEntityList()throws Exception;
}
