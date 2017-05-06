package com.way.algorithm;

/**
 * Test the Java implementation to transform a String to an int and 
 * in reverse transform an int to a String
 * @author reus
 *
 */
public class TypeExchange {
    public static void main(String[] args){
        String str1="1234";
        int x=Integer.valueOf(str1);
        System.out.println(x);
        String str2=String.valueOf(x);
        System.out.println(str2);
    }
}
