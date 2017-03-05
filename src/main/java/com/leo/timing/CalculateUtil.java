package com.leo.timing;

/**
 * Created on 2017/3/2 上午9:03
 * leo linxiaotao1993@vip.qq.com
 */
public class CalculateUtil {

    private static final String FORMAT = "当前方法:%s,执行时间%s毫秒.";
    private static long sStartTime;


    public static void setStartTime(long startTime) {
        sStartTime = startTime;
    }


    public static void run(String methodName,long endTime){
        System.out.println("============================================");
        System.out.println("当前方法: " + methodName);
        System.out.println("执行时间: " + (endTime - sStartTime) + "毫秒");
        System.out.println("============================================");
        System.out.println();
    }
}
