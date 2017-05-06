package com.way.algorithm;

/**
 * 实验Java大小写字母转换
 * @author reus
 *
 */
public class CaseExchange {

    public static void main(String[] args) {
        String str1="1234";
        String str2=str1.toLowerCase();
        String str3=str1.toUpperCase();
        int x=Integer.parseInt(str1);
        String str4=String.valueOf(x);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(x);
        System.out.println(str4);
    }

}
