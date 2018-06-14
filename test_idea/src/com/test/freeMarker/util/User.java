package com.test.freeMarker.util;
/**
 * @PACKAGE com.test.freeMarker.util
 * @Author Administrator
 * @Date created in 2018/6/12 17:29
 * @Description:
 */

import java.io.Serializable;

/**
 * 测试
 * @author Administrator
 * @create 2018-06-12 17:29
 **/
public class User implements Serializable{
    private static final long serialVersionUID = 5333894601952530028L;
    private String name;
    private Integer age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
