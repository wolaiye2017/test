package com.test.email;/**
 * @PACKAGE com.test.email
 * @Author LiJun
 * @Date created in 2018/6/15 15:29
 * @Description:
 */

import com.test.email.util.MailUtil;

/**
 * 邮件测试
 * @author Administrator
 * @create 2018-06-15 15:29
 **/
public class EmailTest {

    public static void main(String[] args) throws Exception{
        MailUtil.sendMessage("798691552@qq.com","你好:<br/>测试","test");
    }
}
