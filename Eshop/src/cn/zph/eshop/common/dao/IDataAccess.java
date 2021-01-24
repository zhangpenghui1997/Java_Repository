package cn.zph.eshop.common.dao;

import java.util.List;

/*访问数据库文件
 * 把所有结果返回给DAO层*/
public interface IDataAccess {
    //List<User> getList(Class<User> clazz)throws Exception;

    <T>List<T> getList(Class<T> clazz)throws Exception;

}
