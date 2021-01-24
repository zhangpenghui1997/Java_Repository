package cn.zph.eshop.common.util;

import java.util.List;
import com.alibaba.fastjson.JSON;
/*JSON工具类
 * 处理JSON相关的所有内容*/
public class JSONUtil {

    public static String Entity2JSON(Object entity) {
        return JSON.toJSONString(entity);

    }

    public static String EntityList2JSON(List<?> entityList) {
        return Entity2JSON(entityList);
    }

    public static Object JSON2Entity(String json, Class<?> clazz) {
        Object obj = JSON.parseObject(json, clazz);
        return obj;

    }

    /*
     * json数据
     * class指定的类型对象
     * <T>指定的类型
     * */
    public static <T> List<T> JSONArray2List(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }

}
