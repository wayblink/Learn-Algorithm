package com.way.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedJson {
    static void mapCreateJson(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","王尼玛");
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("name","小王");
        map1.put("age",7);
        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("name","小尼玛");
        map2.put("age",10);
        List<Map> jsonObjects = new ArrayList<Map>();
        jsonObjects.add(map1);
        jsonObjects.add(map2);
        map.put("fans",jsonObjects);
        //System.out.println("集合中Map创建json对象:" + new JSONObject(map));
    }
    public static void main(String[] args){
        
    }
}
