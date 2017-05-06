package com.way.LB.LBAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.way.LB.IPMap;

public class RoundRobin {
    private static Integer pos=0;
    
    public static String getServer(){
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap =
                new HashMap<String, Integer>();
        serverMap.putAll(IPMap.serverWeightMap);

        // 取得Ip地址List
        Set<Entry<String, Integer>> entrySet = serverMap.entrySet();
        ArrayList<Entry<String, Integer>> keyList = new ArrayList<Entry<String, Integer>>();
        keyList.addAll(entrySet);

        String server = null;
        synchronized (pos)
        {
            if (pos > entrySet.size())
                pos = 0;
            server = keyList.get(pos).getKey();
            pos ++;
        }

        return server;
    }
}
