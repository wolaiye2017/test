package com.test.excel.uitl;
/**
 * @PACKAGE com.test.excel.uitl
 * @Author Administrator
 * @Date created in 2018/5/28 17:39
 * @Description:
 */

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * 写入表格
 *
 * @author Administrator
 * @create 2018-05-28 17:39
 **/
public class WriteExcel {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    private static final Integer cloumnCount = 100;

    public static void writeExcel(List<List> dataList, String finalXlsxPath) {
        OutputStream out = null;
        try {
            // 获取总列数
            int columnNumCount = cloumnCount;
            // 读取Excel文档
            File finalXlsxFile = new File(finalXlsxPath);
            //不存在创建
            System.out.println(finalXlsxFile.exists());
           /* if (!finalXlsxFile.exists()) {
                System.out.print("创建文件:");
                boolean is = finalXlsxFile.createNewFile();
                System.out.println(is);
            }*/
            Workbook workBook = getWorkbok(finalXlsxFile);
            // sheet 对应一个工作页
            Sheet sheet = workBook.getSheetAt(0);
            /**
             * 删除原有数据，除了属性列
             */
            int rowNumber = sheet.getLastRowNum();    // 第一行从0开始算
            System.out.println("原始数据总行数，除属性列：" + rowNumber);
            for (int i = 1; i <= rowNumber; i++) {
                Row row = sheet.getRow(i);
                sheet.removeRow(row);
            }
            // 创建文件输出流，输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
            out = new FileOutputStream(finalXlsxPath);
            workBook.write(out);
            /**
             * 往Excel中写新数据
             */
            for (int j = 0; j < dataList.size(); j++) {
                // 创建一行：从第二行开始，跳过属性列
                Row row = sheet.createRow(j);
                // 得到要插入的每一条记录
                List dataMap = dataList.get(j);
               /* String name = dataMap.get("BankName").toString();
                String address = dataMap.get("Addr").toString();
                String phone = dataMap.get("Phone").toString();*/
                for (int k = 0; k < dataMap.size(); k++) {
                    Cell cell = row.createCell(k);
                    cell.setCellValue(dataMap.get(k).toString());
                }
            }
            // 创建文件输出流，准备输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
            out = new FileOutputStream(finalXlsxPath);
            workBook.write(out);
            System.out.println("数据导出成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(out != null){
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Workbook getWorkbok(File file) throws Exception {
        Workbook wb = null;
        if(!file.exists()){
            if (file.getName().endsWith(EXCEL_XLS)) {     //Excel&nbsp;2003
                HSSFWorkbook workbook = new HSSFWorkbook();
                workbook.createSheet("sheet0");
                wb = workbook;
            } else if (file.getName().endsWith(EXCEL_XLSX)) {    // Excel 2007/2010
                XSSFWorkbook workbook = new XSSFWorkbook();
                workbook.createSheet("sheet0");
                wb = workbook;
            }
            return wb;
        }
        FileInputStream in = new FileInputStream(file);

        if (file.getName().endsWith(EXCEL_XLS)) {     //Excel&nbsp;2003
            wb = new HSSFWorkbook(in);
        } else if (file.getName().endsWith(EXCEL_XLSX)) {    // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }


}
