package com.way.datastruct.graph;

import java.util.LinkedList;

public class ListDG {
    Vertex[] vertexLists;
    int size;
    
    class Vertex{
        char ch;
        Vertex next;
        
        Vertex(char ch){
            this.ch=ch;
        }
        void add(char ch){
            Vertex node=this;
            while(node.next!=null){
                node=node.next;
            }
            node.next=new Vertex(ch);
        }

        
    }
    
    public ListDG(char[] vertexs,char[][] edges){
        
        size=vertexs.length;
        this.vertexLists=new Vertex[size];
        for(int i=0;i<size;i++){
            this.vertexLists[i]=new Vertex(vertexs[i]);
        }
        
        for(char[] c:edges){
           int p=getPosition(c[0]);
           vertexLists[p].add(c[1]);
        }
        
    }
    
    private int getPosition(char ch) {
        for(int i=0; i<size; i++)
            if(vertexLists[i].ch==ch)
                return i;
        return -1;
    }
    
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
    
    //拓扑排序，如果无环，输出排序队列，返回1，若果有环，返回-1
    public int topoSort(){
        //设置是否访问过标记，初始化都是false
        boolean[] visited=new boolean[size];
        for(int i=0;i<size;i++){
            visited[i]=false;
        }
        
        //拓扑排序结果存储队列
        LinkedList<Vertex> topo=new LinkedList<Vertex>();
        
        //调用拓扑排序算法
        int result=topoSort(visited,topo);
        
        //输出拓扑排序结果
        if(result==1){
            for(int i=0;i<topo.size();i++){
                System.out.println(topo.get(i).ch);
            }
        }
        
        return result;
    }
    
    private int topoSort(boolean[] visited,LinkedList<Vertex> topo){
        //1，计算每个顶点的入度
        int[] inDegree=new int[size];
        for(int i=0;i<size;i++){
            Vertex node=vertexLists[i];
            while(node!=null){
                if(visited[i]==false){
                    inDegree[getPosition(node.ch)]++;
                }
                node=node.next;
            }
            inDegree[i]--;//头节点不算所以减去1
        }

        //2，是否有环标记
        boolean hasCircle=true;
        for(int i=0;i<size;i++){
            if(inDegree[i]==0&&visited[i]==false){//如果一个顶点入度为零且未被排序，则需要加入到队列中，且说明还没有发现环
                hasCircle=false;
                topo.add(vertexLists[i]);//加入到队列中
//                System.out.println(vertexs[i]);
                visited[i]=true;//标记该顶点已被访问过
            }                
        }
        if(hasCircle){//如果不存在还未被排序且入度为零的点，说明剩余的顶点构成了环，返回-1
            System.out.println("Has Circle");
            return -1;
        }
        
        //3,如果还可以继续进行排序，检验是否已全部排序过,通过已排序的顶点数量可以判断
        if(size!=topo.size()){
            return topoSort(visited,topo);
        }else{
            return 1; //如果都排序过了返回1
        }
    }
    
    public static void main(String[] args){
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = new char[][]{
            {'B', 'A'}, 
            {'B', 'D'}, 
            {'A', 'G'},
            {'D', 'E'},
            {'D', 'F'}, 
            {'C', 'F'}, 
            {'C', 'G'}};
            
        ListDG pG;

        
        pG = new ListDG(vexs, edges);
//        pG.print();   // 打印图 

//        pG.DFS();
//        
//        pG.BFS();
        System.out.println(pG.topoSort());
//        long start=System.nanoTime();
//        
//        for(int i=0;i<10000;i++){
//            pG = new ListDG(vexs, edges);
//            //pG.print();   // 打印图 
//        }
//
//        long end=System.nanoTime();
//        
//        System.out.println(end-start);
        
    }
}
