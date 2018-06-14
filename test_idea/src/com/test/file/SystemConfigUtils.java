package com.test.file;

import com.sun.javaws.security.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * 默认配置文件：system.properties
 * <p>
 * Created by quanjic on 2017/11/9 16:13
 **/
public class SystemConfigUtils {

    private static SystemConfigUtils instance;

    private static Properties properties = new Properties();

    static {
        getInstance();
    }

    protected SystemConfigUtils() {
        init();
    }

    private static synchronized SystemConfigUtils getInstance() {
        if (instance == null) {
            instance = new SystemConfigUtils();
        }
        return instance;
    }

    private String path = "/system.properties";

    private void init() {
        InputStream ism = null;
        try {
            properties = System.getProperties();
            ism = getClass().getResourceAsStream(path);
            properties.load(new InputStreamReader(ism, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           if(ism != null){
               try {
                   ism.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    /**
     *
     * @return
     */
    /*public static String get(String key, String defaultVal) {
        return StringUtils.defaultIfEmpty(get(key), defaultVal);
    }*/
    public static void main(String[] args) throws UnsupportedEncodingException {
        String string = SystemConfigUtils.get("aliSMS.sign");
        System.out.println(new String(string.getBytes("ISO-8859-1"),"gbk"));
        System.out.println(string);
    }
}
