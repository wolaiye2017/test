package com.test.oracl;
/**
 * @PACKAGE com.test.oracl
 * @Author Administrator
 * @Date created in 2018/5/28 16:51
 * @Description:
 */

import com.test.oracl.util.DBUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.test.excel.uitl.WriteExcel.writeExcel;

/**
 * oracle测试
 * @author Administrator
 * @create 2018-05-28 16:51
 **/
public class Test {

    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            try {
                ResultSet result = DBUtil.find("select t.* from (select distinct user_id from a_award_detail  PARTITION(p"+i+") ) t where rownum <= 1000");
                if(result == null)return;
                List<String> data =new ArrayList<>();
                List<List> list=new ArrayList<List>();
                try{
                    File txt = new File("D:/tmp/aam/userId.txt");
                    while (result.next()){
                        data =new ArrayList<>();
                        String userId = result.getString(1);
                        FileWriter fw = new FileWriter(txt,true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(userId);
                        bw.newLine();
                        bw.flush();
                        bw.close();
                        fw.close();
                   /* System.out.println(userId);
                    data.add(userId);
                    list.add(data);*/
                    }
                    System.out.println("导出数据:"+i);
                }catch (Exception e){
                    System.err.println("导出数据异常:"+i);
                }
                //writeExcel(list,  "D:/tmp/aam/p"+i+".xlsx");

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
