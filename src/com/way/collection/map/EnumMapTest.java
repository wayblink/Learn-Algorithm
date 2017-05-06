package com.way.collection.map;

import java.util.EnumMap;

public class EnumMapTest {

    public enum Season{
        SPRING,SUMMER,autumn,winter;
    }
    
    public static void main(String[] args){
        EnumMap enumMap=new EnumMap(Season.class);
        enumMap.put(Season.SPRING, "春暖花开");
        enumMap.put(Season.SUMMER, "惠风和畅");
        enumMap.put(Season.autumn, "秋高气爽");
        //enumMap.put(Season.winter, "北风猎猎");
        System.out.println(enumMap);
    }
}
