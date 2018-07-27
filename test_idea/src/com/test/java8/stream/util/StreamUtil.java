package com.test.java8.stream.util;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class StreamUtil {

    //集合空字符数量
    public static Long getCountLength4Java7(List<String> list){
        Long count = 0L;
        Long time = System.currentTimeMillis();
        for (String str : list) {
            if(str.isEmpty()){
                count++;
            }
        }
        System.out.println("java7 cos:"+(System.currentTimeMillis() - time));
        return count;
    }

    public static Long getCountLength4Java8(List<String> list){
        Long count = 0L;
        Long time = System.currentTimeMillis();
        count = list.stream().filter(str -> str.isEmpty()).count();
        System.out.println("java8 cos:"+(System.currentTimeMillis() - time));
        return count;
    }
    //集合字符串长度为 n 的数量
    public static Long getCountLengthN4Java7(List<String> list,Integer n){
        Long time = System.currentTimeMillis();
        Long count = 0L;
        for (String str : list) {
            if(str.length() >= n){
                count++;
            }
        }
        System.out.println("java7 cos:"+(System.currentTimeMillis() - time));
        return count;
    }
    public static Long getCountLengthN4Java8(List<String> list,Integer n){
        Long time = System.currentTimeMillis();
        Long count = 0L;
        count = list.stream().filter(str -> str.length()>= n ).count();
        System.out.println("java8 cos:"+(System.currentTimeMillis() - time));
        return count;
    }

    //并行数组
    public static void bx(){
        Long time = System.currentTimeMillis();
        long[] arrayOfLong = new long [ 20000 ];
        Arrays.parallelSetAll(arrayOfLong,index -> ThreadLocalRandom.current().nextInt(1000000 ));

        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i+" "));
        System.out.println();
        Arrays.parallelSort(arrayOfLong);

        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i+" "));
        System.out.println();
        System.out.println("cos:"+(System.currentTimeMillis() - time));
    }

    public static void bx7(){
        Long time = System.currentTimeMillis();
        long[] arrayOfLong = new long [ 20000 ];
        for (int i = 0 ; i < arrayOfLong.length;i++){
            arrayOfLong[i] = ThreadLocalRandom.current().nextInt(1000000 );
        }
        for (int i = 0 ; i < 10;i++){
            System.out.print(arrayOfLong[i]+" ");
        }
        System.out.println();
        Arrays.sort(arrayOfLong);
        for (int i = 0 ; i < 10;i++){
            System.out.print(arrayOfLong[i]+" ");
        }
        System.out.println();
        System.out.println("cos:"+(System.currentTimeMillis() - time));
    }

}
