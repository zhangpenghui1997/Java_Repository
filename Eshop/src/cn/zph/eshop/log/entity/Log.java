package cn.zph.eshop.log.entity;

public class Log {
    //日志内容
    private String msg;
    //日志级别
    private String level;
    //日志发生的时间
    private String time;

    public Log() {
    }

    public Log(String msg, String level, String time) {
        this.msg = msg;
        this.level = level;
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "["+time+"] "+level+":"+msg;
    }
}
