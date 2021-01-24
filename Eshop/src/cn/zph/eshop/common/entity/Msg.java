package cn.zph.eshop.common.entity;

import java.util.UUID;

public class Msg {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";

    //消息类型  成功：success 失败：fail
    private String type;
    //消息内容
    private String msg;

    //用于携带数据到客户端
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static String getSUCCESS() {
        return SUCCESS;
    }

    public static String getFAIL() {
        return FAIL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
