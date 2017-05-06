package com.way.LB.LBAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.way.LB.IPMap;

public class WeightRoundRobin {
    private static Integer pos;
    
    public static String getServer(){
        
        Map<String,Integer> ipServerMap=new HashMap<String,Integer>();
        ipServerMap.putAll(IPMap.serverWeightMap);
        
        Set<Entry<String,Integer>> ipSet=ipServerMap.entrySet();
        
        ArrayList<String> ipList=new ArrayList<String>();
        
        for(Entry<String,Integer> entry:ipSet){
            for(int i=0;i<entry.getValue();i++){
                ipList.add(entry.getKey());
            }
            
        }
        
        String ipStr=null;
        synchronized (pos) {
            if(pos>ipList.size()){
                pos=0;
            }
            pos++;
            ipStr=ipList.get(pos);
        }

        return ipStr;
    }
}
