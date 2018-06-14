package com.test.md5;
/**
 * @PACKAGE com.test.md5
 * @Author Administrator
 * @Date created in 2018/6/1 14:02
 * @Description:
 */

import com.test.md5.uitl.MD5Util;

/**
 *mds5测试
 * @author Administrator
 * @create 2018-06-01 14:02
 **/
public class MD5Test {
    public static void main(String[] args) throws Exception{
        String ym = "e10adc3949ba59abbe56e057f20f883e";
       String md5 =  MD5Util.getMD5("123456");
        System.out.println(md5);
        System.out.println(ym.toUpperCase().equals(md5));
    }
}
