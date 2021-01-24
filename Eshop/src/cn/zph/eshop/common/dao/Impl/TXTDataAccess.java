package cn.zph.eshop.common.dao.Impl;

import cn.zph.eshop.common.dao.IDataAccess;
import cn.zph.eshop.common.util.FileUtil;
import cn.zph.eshop.common.util.JSONUtil;

import java.io.File;
import java.util.List;

/*
 * 获取数据列表
 * 1.根据实体类的字节码文件对象获取类名
 * 2.根据类名获取用户数据文件名
 * 3.合成数据文件路径
 * 4.使用文件操作工具读取文件的字符串数据
 * 5.将字符串数据转换成List<User>对象并返回
 * */
public class TXTDataAccess implements IDataAccess {
    @Override
    public <T> List<T> getList(Class<T> clazz)  {
        try{
            //1.根据实体类的字节码文件对象获取类名
            String username = clazz.getSimpleName().toLowerCase();//User-->user
            //2.根据类名获取用户数据文件名
            String dataFileName = "db_" + username + ".txt";//db_user.txt.txt
            //3.合成数据文件路径
            String dataFilePath ="db/"+dataFileName;
            //4.使用文件操作工具读取文件的字符串数据
            String dataJson=FileUtil.readByBuffered(dataFilePath);
            return JSONUtil.JSONArray2List(dataJson,clazz);

        }catch (Exception e){
            System.out.println("读取文件异常");
            return null;
        }


    }

}
