package com.test.java8.stream;

import com.test.java8.stream.util.StreamUtil;

import java.util.Arrays;
import java.util.List;

public class StreamTest {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        System.out.println("java 7:"+StreamUtil.getCountLength4Java7(strings));
//        System.out.println("java 8:"+StreamUtil.getCountLength4Java8(strings));

        System.out.println("java 7:"+StreamUtil.getCountLengthN4Java7(strings,3));
        System.out.println("java 8:"+StreamUtil.getCountLengthN4Java8(strings,3));

        StreamUtil.bx();
        StreamUtil.bx7();
//        StreamUtil
    }
}
