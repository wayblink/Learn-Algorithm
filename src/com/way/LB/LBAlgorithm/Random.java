package com.way.LB.LBAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.way.LB.IPMap;

public class Random {

    public static String getServer(){
        
        Map<String,Integer> serverIPMap=new HashMap<String,Integer>();
        serverIPMap.putAll(IPMap.serverWeightMap);

        Set<String> ipSet=serverIPMap.keySet();
        ArrayList<String> ipList=new ArrayList<String>();
        ipList.addAll(ipSet);
        
        java.util.Random random=new java.util.Random();
        int randompos=random.nextInt(ipList.size());
        
        
        return ipList.get(randompos);
    }
    
}