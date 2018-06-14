package com.test.date;
/**
 * @PACKAGE com.test.date
 * @Author Administrator
 * @Date created in 2018/6/4 09:37
 * @Description:
 */

import java.util.concurrent.TimeUnit;

/**
 * 时间测试
 * @author Administrator
 * @create 2018-06-04 9:37
 **/
public class DateTest {
    public static void main(String[] args) {
        TimeUnit timeUnit = TimeUnit.SECONDS; //单位为天
        printTime(timeUnit,1);
    }

    public static void printTime(TimeUnit timeUnit, int time){
        System.out.println("======= begin =======,input:"+time+timeUnit.name());
        System.out.println("timeUnit.toNanos:"+timeUnit.toNanos(time));
        System.out.println("timeUnit.toMicros:"+timeUnit.toMicros(time));
        System.out.println("timeUnit.toDays:"+timeUnit.toDays(time));
        System.out.println("timeUnit.toHours:"+timeUnit.toHours(time));
        System.out.println("timeUnit.toMinutes:"+timeUnit.toMinutes(time));
        System.out.println("timeUnit.toSeconds:"+timeUnit.toSeconds(time));
        System.out.println("timeUnit.toMillis:"+timeUnit.toMillis(time));
        System.out.println("1天是"+(timeUnit.convert(1, TimeUnit.DAYS))+timeUnit.name());
        System.out.println("12小时是"+(timeUnit.convert(12, TimeUnit.HOURS))+timeUnit.name());
        System.out.println("3600秒是"+(timeUnit.convert(36000, TimeUnit.MINUTES))+timeUnit.name());
        System.out.println("======= end =======");
    }
}
