package com.way.LB;

import java.util.HashMap;

public class IPMap {

    public static HashMap<String,Integer> serverWeightMap=new HashMap<String,Integer>();
    
    static{
        serverWeightMap.put("http://www.baidu.com",1);
        serverWeightMap.put("http://www.qq.com", 2);
        serverWeightMap.put("http://www.taobao.com", 3);
    }
    
}
