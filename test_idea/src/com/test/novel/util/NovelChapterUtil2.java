package com.test.novel.util;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NovelChapterUtil2 {

    private static Pattern PATTERN = Pattern.compile("第*章");

    public static void cut(String srcFilePath,String dstDir){
        BufferedReader br=null;
        BufferedWriter bw=null;
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(srcFilePath), "GBK");
            br = new BufferedReader(isr);
            String tempString=null;
            StringBuffer sb=new StringBuffer();
            Pattern p=Pattern.compile(".*?第.*?章.*?");
//            Pattern p=Pattern.compile("第.*?章");
            Matcher m=null;
            int index=0;
            int i=0;
            File file;
            while((tempString=br.readLine())!=null){
                tempString+="\r\n";
                sb.append(tempString);
            }
            m=p.matcher(sb);
            while(m.find()){
                file=new File("D:/test/"+i+".txt");
                bw=new BufferedWriter(new FileWriter(file));
                int start = m.start();
                if(m.find()){
                    index=m.start();
                    bw.write(sb.toString(),start, index-start);
                    bw.flush();
                    m.region(index,sb.length());
                }else{
                    bw.write(sb.toString(),start, sb.length()-start);
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch(IOException ie){
            ie.printStackTrace();
        }
        finally{
            try {
                if(br!=null){
                    br.close();
                }
                if(bw!=null){
                    bw.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
