package cn.zph.util;

import javax.servlet.http.Cookie;

public class CookieUtils {
    /**
     * 查找指定名称的Cookie对象
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name,Cookie [] cookies){
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }
        Cookie destCookie=null;
        for(Cookie cookie:cookies){
            if(name.equals(cookie.getName())){
                destCookie=cookie;
                break;
            }
        }
        return destCookie;

    }
}
