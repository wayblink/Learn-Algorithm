package com.way.datastruct.tree;

public class Graph {
    static final int MaxNum=20;
    static final int MaxValue=65535;
    
    char[] vertex=new char[MaxNum];
    int type;
    int VertexNum;
    int EdgeNum;
    int[][] EdgeWeight=new int[MaxNum][MaxNum];
    int[] isTrav=new int[MaxNum];
    
    void CreateGraph(){
        
    }

}
