package com.test.novel.util;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NovelChapterUtil {

    private static Pattern PATTERN = Pattern.compile("第*章");

    public static void cut(String srcFilePath,String dstDir){
        BufferedReader br=null;
        BufferedWriter bw=null;
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(srcFilePath), "GBK");
            br = new BufferedReader(isr);
            StringBuffer sb=new StringBuffer();
            Matcher m=null;
            int index=0;
            int i=0;
            String line=null;
            File file;
            while((line=br.readLine())!=null){
//                line+="\r\n";
//                sb.append(line);
                if(line.indexOf("第") == 0 && (line.indexOf("节") != -1 || line.indexOf("章") != -1)) {
                    sb = new StringBuffer();
                    sb.append(line);
                    System.out.println(line);
                    file=new File(dstDir+"/"+line+".txt");

                    bw=new BufferedWriter(new FileWriter(file));
                }
                if(bw != null){
                    bw.write(line.toString());
                    bw.write("\r\n");
                    bw.flush();
                }
            }

           /* m=PATTERN.matcher(sb);
            while(m.find()){
                System.out.println(sb.toString().substring(index,m.start()));
                file=new File(dstDir+"/"+i+".txt");
                bw=new BufferedWriter(new FileWriter(file));
                //bw.write(sb.toString(), index, m.start());
                index=m.start();
                i++;
            }
            file=new File(dstDir+"/"+i+".txt");
            bw=new BufferedWriter(new FileWriter(file));
            //bw.write(sb.toString(), index, (int) file.length());*/

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(br!=null){
                    br.close();
                }
                if(bw!=null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
