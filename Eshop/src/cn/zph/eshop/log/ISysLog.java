package cn.zph.eshop.log;

public interface ISysLog {
    public static final String INFO="INFO";
    public static final String WARN="WARN";
    public static final String ERROR="ERROR";
    public void info(String msg);
    public void warn(String msg);
    public void error(String msg);


}
