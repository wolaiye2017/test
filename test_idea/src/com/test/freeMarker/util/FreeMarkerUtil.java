package com.test.freeMarker.util;
/**
 * @PACKAGE com.test.freeMarker.util
 * @Author Administrator
 * @Date created in 2018/6/12 16:42
 * @Description:
 */


import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

/**
 * freeMarker工具
 * @author Administrator
 * @create 2018-06-12 16:42
 **/
public class FreeMarkerUtil {

    public static void getHtml() throws Exception{
        Configuration configuration = new Configuration();
        configuration.setDirectoryForTemplateLoading(new File("G:\\img\\template"));
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码
        Template template = configuration.getTemplate("static.html");
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("description", "我正在学习使用Freemarker生成静态文件！");
        List<String> nameList = new ArrayList<String>();
        nameList.add("陈靖仇");
        nameList.add("玉儿");
        nameList.add("宇文拓");
        paramMap.put("nameList", nameList);

        Map<String, Object> weaponMap = new HashMap<String, Object>();
        weaponMap.put("first", "轩辕剑");
        weaponMap.put("second", "崆峒印");
        weaponMap.put("third", "女娲石");
        weaponMap.put("fourth", "神农鼎");
        weaponMap.put("fifth", "伏羲琴");
        weaponMap.put("sixth", "昆仑镜");
        weaponMap.put("seventh", null);
        paramMap.put("weaponMap", weaponMap);

        paramMap.put("date",new Date());
        paramMap.put("answer",13);

        paramMap.put("foo",true);

        paramMap.put("x",2.58963);
        paramMap.put("y",2);

        User user = new User();
        user.setName("lijun");
        user.setAge(12);
        paramMap.put("user",user);
        Writer writer  = new OutputStreamWriter(new FileOutputStream("success.html"),"UTF-8");
        template.process(paramMap, writer);
        System.out.println("恭喜，生成成功~~");

    }

}
