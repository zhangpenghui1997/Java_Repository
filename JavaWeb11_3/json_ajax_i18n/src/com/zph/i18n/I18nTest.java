package com.zph.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nTest {
    @Test
    public void testLocale(){
    /*    Locale locale=Locale.getDefault();
        System.out.println(locale);

        for(Locale l:Locale.getAvailableLocales()){
            System.out.println(l);
        }*/
        System.out.println(Locale.CHINA);
        System.out.println(Locale.US);
    }

    @Test
    public void testI18n(){
        Locale locale=Locale.CHINA;

        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        System.out.println("username："+bundle.getString("username"));
    }
}
