package cn.zph.eshop.common.action;

import cn.zph.eshop.log.ISysLog;
import cn.zph.eshop.log.impl.ConsoleLog;

/*封装请求数据；
 * 校验权限
 * 调用service层处理业务逻辑
 * 返回消息到客户端*/
public class BaseAction {
    protected ISysLog log=new ConsoleLog();

}
