package cn.zph.eshop.log.impl;

import cn.zph.eshop.log.ISysLog;
import cn.zph.eshop.log.entity.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/*日志实现类
* 在控制台打印日志信息
* 步骤
* 1.封装日志对象
* 2.打印日志数据到控制台
* */
public class ConsoleLog implements ISysLog {
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");//日期格式化类
    @Override
    public void info(String msg) {
        //封装日志对象
        String log=new Log(msg,INFO,sdf.format(new Date())).toString();
        System.out.println(log);//打印日志信息INFO

    }

    @Override
    public void warn(String msg) {
        String log=new Log(msg,WARN,sdf.format(new Date())).toString();
        System.out.println(log);//打印日志信息WARN

    }

    @Override
    public void error(String msg) {
        String log=new Log(msg,ERROR,sdf.format(new Date())).toString();
        System.out.println(log);//打印日志信息ERROR

    }
}
