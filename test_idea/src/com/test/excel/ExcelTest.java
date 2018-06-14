package com.test.excel;
/**
 * @PACKAGE com.test.excel
 * @Author Administrator
 * @Date created in 2018/5/28 17:38
 * @Description:
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.test.excel.uitl.ReadExcel.readExcel;
import static com.test.excel.uitl.WriteExcel.writeExcel;

/**
 * 表格测试
 * @author Administrator
 * @create 2018-05-28 17:38
 **/
public class ExcelTest {

    public static void main(String[] args) {

        for (int i = 1; i < 101; i++) {
            try{
                String path = "D:/tmp/aam/p"+i+".xlsx";
                File file = new File(path);
                File txt = new File("D:/tmp/aam/userId.txt");
                List data =readExcel(file);
                List list = (List) data.get(0);
                for (int j = 0; j < list.size(); j++) {
                    List col = (List) list.get(j);
//                    System.out.println(col.get(0));
                    FileWriter fw = new FileWriter(txt,true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(col.get(0).toString());
                    bw.newLine();
                    bw.flush();
                    bw.close();
                    fw.close();
                }
                System.out.println("完成:"+i);
            }catch (Exception e){
                System.err.println("异常:"+i);
            }
        }
        /*List<String> dataMap=new ArrayList<>();
        dataMap.add("BankName");
        dataMap.add("Addr");
        dataMap.add("Phone");
        List<List> list=new ArrayList<List>();
        list.add(dataMap);
        writeExcel(list,  "D:/tmp/writeExcel2.xlsx");*/
        /*File file = new File("D:/tmp/p1.xlsx");
        List data =readExcel(file);
        System.out.println(data);*/
    }

}
