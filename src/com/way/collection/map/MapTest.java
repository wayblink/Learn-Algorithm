package com.way.collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String args[]){
        //Map map=new HashMap();
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("Kobe", 24);
        map.put("James", 23);
        map.put("Garnett",21);
        map.put(null, 1);
        int num1=(int) map.get("Kobe");
        map.remove("kobe");
        System.out.println(num1);
        System.out.println(map.get(null));
    }
}
