package com.way.string;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args){
        HashMap<Integer,String> map=new HashMap<Integer,String>();
        String str="flahuf";
        String str2="flahuf";
        char[] dst=new char[10];
        str.getChars(0, str.length(), dst, 0);
//        for(char c:dst){
//            System.out.println(c);
//            System.out.println((int)c);
//        }

        System.out.println(str.equals(str2));
      
    }
}
