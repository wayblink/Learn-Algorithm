package com.way.datastruct.graph;

import java.util.LinkedList;

public class ListDG2 {
    
    LinkedList<Character>[] vertexLists;
    int size;
    
    public ListDG2(char[] vertexs,char[][] edges){
        size=vertexs.length;
        this.vertexLists=new LinkedList[size];
        
        for(int i=0;i<size;i++){
            this.vertexLists[i]=new LinkedList<Character>();
            vertexLists[i].add(vertexs[i]);
        }

        for(char[] c:edges){
            int p=getPosition(c[0]);
            this.vertexLists[p].add(c[1]);
         }
        
    }
    
    private int getPosition(char ch) {
        for(int i=0; i<size; i++)
            if(vertexLists[i].get(0)==ch)
                return i;
        return -1;
    }
    
    public void print(){
       for(int i=0;i<size;i++){
           LinkedList<Character> temp=vertexLists[i];
           for(int j=0;j<temp.size();j++){
               System.out.print(temp.get(j)+" ");
           }
           System.out.println();
       }
    }
    
    public static void main(String[] args){
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = new char[][]{
            {'A', 'C'}, 
            {'A', 'D'}, 
            {'A', 'F'}, 
            {'B', 'C'}, 
            {'C', 'D'}, 
            {'F', 'G'}, 
            {'E', 'G'}};
            
        ListDG2 pG;

        long start=System.nanoTime();
        
        for(int i=0;i<10000;i++){
            pG = new ListDG2(vexs, edges);
            //pG.print();   // 打印图 
        }

        long end=System.nanoTime();
        
        System.out.println(end-start);
    }

}
