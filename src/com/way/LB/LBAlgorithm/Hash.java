package com.way.LB.LBAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.way.LB.IPMap;

public class Hash {

    public static String getServer(){
        Map<String,Integer> ipServerMap=new HashMap<String,Integer>();
        ipServerMap.putAll(IPMap.serverWeightMap);
        
        Set<String> ipSet=ipServerMap.keySet();
        ArrayList<String> ipList=new ArrayList<String>();
        
        ipList.addAll(ipSet);
        
        String clientIP="127.0.0.1";
        int hashCode=clientIP.hashCode();
        
        int ipPos=hashCode%ipList.size();
        
        return ipList.get(ipPos);
        
    }
}
