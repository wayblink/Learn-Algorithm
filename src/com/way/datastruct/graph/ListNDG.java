package com.way.datastruct.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ListNDG {
    Vertex[] vertexLists;//邻接表数组
    int size;
    class Vertex{//邻接表节点类，单链表数据结构
        char ch;
        Vertex next;
        
        Vertex(char ch){//初始化方法
            this.ch=ch;
        }
        void add(char ch){//加到链表尾
            Vertex node=this;
            while(node.next!=null){
                node=node.next;
            }
            node.next=new Vertex(ch);
        }
    }
    
    public ListNDG(char[] vertexs,char[][] edges){
        
        size=vertexs.length;
        this.vertexLists=new Vertex[size];//确定邻接表大小
        //设置邻接表头节点
        for(int i=0;i<size;i++){
            this.vertexLists[i]=new Vertex(vertexs[i]);
        }
        //存储边信息
        for(char[] c:edges){
           int p1=getPosition(c[0]);
           vertexLists[p1].add(c[1]);
           int p2=getPosition(c[1]);
           vertexLists[p2].add(c[0]);
        }
        
    }
    
    //跟据顶点名称获取链表下标
    private int getPosition(char ch) {
        for(int i=0; i<size; i++)
            if(vertexLists[i].ch==ch)
                return i;
        return -1;
    }
    
    //遍历输出邻接表
    public void print(){
       for(int i=0;i<size;i++){
           Vertex temp=vertexLists[i];
           while(temp!=null){
               System.out.print(temp.ch+" ");
               temp=temp.next;
           }
           System.out.println();
       }
    }
    
    public void DFS(){
        boolean[] beTraversed=new boolean[size];
        for(int i=0;i<size;i++){
            beTraversed[i]=false;
        }
        for (int i = 0; i < size; i++) {
            if (!beTraversed[i])
                DFS(beTraversed,vertexLists[i]);
        }
        
    }
    
    public void DFS(boolean[] beTraversed,Vertex temp){
        
        System.out.println(temp.ch);
        beTraversed[getPosition(temp.ch)]=true;
        
        while(temp!=null){
            if(beTraversed[getPosition(temp.ch)]==false){
                DFS(beTraversed,vertexLists[getPosition(temp.ch)]);
            }
            temp=temp.next;
        }
        
    }
    
    public void BFS(){
        boolean[] isTraversed=new boolean[size];
        for(int i=0;i<size;i++){
            isTraversed[i]=false;
        }
        System.out.println(vertexLists[0].ch);
        isTraversed[0]=true;
        BFS(0,isTraversed);
    }
    
    public void BFS(int x,boolean[] isTraversed){
        Vertex temp=vertexLists[x];
        LinkedList<Vertex> list=new LinkedList<Vertex>();
        while(temp!=null){
            if(isTraversed[getPosition(temp.ch)]==false){
                System.out.println(temp.ch);
                isTraversed[getPosition(temp.ch)]=true;
                list.add(temp);
            }
            temp=temp.next;
        }
        while(!list.isEmpty()){
            Vertex v=list.pop();
            int t=getPosition(v.ch);
            BFS(t,isTraversed);
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
            
        ListNDG pG;
        
        
        pG = new ListNDG(vexs, edges);
        pG.print();   // 打印图 

        pG.DFS();
        
        pG.BFS();

//        long start=System.nanoTime();
//        
//        for(int i=0;i<10000;i++){
//            pG = new ListNDG(vexs, edges);
//            //pG.print();   // 打印图 
//        }
//
//        long end=System.nanoTime();
//        
//        System.out.println(end-start);
        
    }


    
}
