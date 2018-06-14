package com.test.oracl.util;
/**
 * @PACKAGE com.test.oracl.util
 * @Author Administrator
 * @Date created in 2018/5/28 17:02
 * @Description:
 */

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * oracle连接工具
 * @author Administrator
 * @create 2018-05-28 17:02
 **/
public class DBUtil {

    private static Connection con;
    private static String url;
    private static String user;
    private static String pwd;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");/*如果是MySQL就改为Class.forName("com.mysql.jdbc.Driver");*/
            InputStream is = DBUtil.class.getResourceAsStream("/db.properties");//db.properties 是一个用户配置文件传用户名密码
            Properties prop=new Properties();
            prop.load(is);
            url=prop.getProperty("url");
            user=prop.getProperty("user");
            pwd=prop.getProperty("password");
            con = DriverManager.getConnection(url, user, pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ResultSet find(String sql){
        con=getCon();
        try {
            Statement smt=con.createStatement();
            ResultSet rs=smt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ResultSet find(String sql,Object ...pram){//...pram数组
        con=getCon();
        try {
            PreparedStatement smt=con.prepareStatement(sql);
            for (int i=0;i<pram.length;i++){
                smt.setObject(i+1,pram[i]);
            }
            ResultSet rs=smt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void insert(String sql,Object ...pram){//...pram数组
        con=getCon();
        try {
            PreparedStatement smt=con.prepareStatement(sql);
            for (int i=0;i<pram.length;i++){
                smt.setObject(i+1,pram[i]);
            }
            smt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getCon(){
        try {
            if(con==null||con.isClosed())
                con = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }


}
