package com.test.excel.uitl;/**
 * @PACKAGE com.test.excel.uitl
 * @Author Administrator
 * @Date created in 2018/5/28 18:42
 * @Description:
 */

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取数据
 * @author Administrator
 * @create 2018-05-28 18:42
 **/
public class ReadExcel {

    public static List readExcel(File file) {
        try{
            // 获得工作簿
            Workbook workbook = WorkbookFactory.create(file);
            // 获得工作表个数
            int sheetCount = workbook.getNumberOfSheets();
            List data = new ArrayList();
            // 遍历工作表
            for (int i = 0; i < sheetCount; i++){
                Sheet sheet = workbook.getSheetAt(i);
                // 获得行数
                int rows = sheet.getLastRowNum() + 1;
                // 获得列数，先获得一行，在得到改行列数
                Row tmp = sheet.getRow(0);
                if (tmp == null) {
                    continue;
                }
                int cols = tmp.getPhysicalNumberOfCells();
                // 读取数据
                List list = new ArrayList();
                for (int row = 0; row < rows; row++){
                    Row r = sheet.getRow(row);
                    List coList = new ArrayList();
                    for (int col = 0; col < cols; col++){
                        coList.add(r.getCell(col).getStringCellValue());
                    }//end col
                    list.add(coList);
                }//end row
                data.add(list);
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
