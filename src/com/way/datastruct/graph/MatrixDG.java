package com.way.datastruct.graph;

import java.util.LinkedList;

public class MatrixDG {
    int size;
    char[] vertexs;
    int[][] matrix;
    
    public MatrixDG(char[] vertexs,char[][] edges){
        size=vertexs.length;
        matrix=new int[size][size];
        this.vertexs=vertexs;
        
        for(char[] c:edges){
            int p1 = getPosition(c[0]);
            int p2 = getPosition(c[1]);
            
            matrix[p1][p2] = 1;
        }
        
    }
    
    public void print(){
        for(int[] i:matrix){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    
    private int getPosition(char ch) {
        for(int i=0; i<vertexs.length; i++)
            if(vertexs[i]==ch)
                return i;
        return -1;
    }
    
    public void DFS(){
        boolean[] beTraversed=new boolean[size];
        for(int i=0;i<size;i++){
            beTraversed[i]=false;
        }
        System.out.println(vertexs[0]);
        beTraversed[0]=true;
        DFS(0,0,beTraversed);
    }
    
    private void DFS(int x,int y,boolean[] beTraversed){
        while(y<=size-1){
            if(matrix[x][y]!=0&beTraversed[y]==false){
                System.out.println(vertexs[y]);
                beTraversed[y]=true;
                DFS(y,0,beTraversed);
            }
            y++;
        }
    }
    
    public void BFS(){
        boolean[] beTraversed=new boolean[size];
        for(int i=0;i<size;i++){
            beTraversed[i]=false;
        }
        System.out.println(vertexs[0]);
        beTraversed[0]=true;
        BFS(0,beTraversed);
    }
    
    public void BFS(int x,boolean[] beTraversed){
        LinkedList<Character> list=new LinkedList<Character>();
        int y=0;
        while(y<=size-1){
            if(matrix[x][y]!=0&beTraversed[y]==false){
                System.out.println(vertexs[y]);
                beTraversed[y]=true;
                list.add(vertexs[y]);
            }
            y++;
        }
        while(!list.isEmpty()){
            char ch=list.pop();
            int t=getPosition(ch);
            BFS(t,beTraversed);
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
        LinkedList<Integer> topo=new LinkedList<Integer>();
        
        //调用拓扑排序算法
        int result=topoSort(visited,topo);
        
        //输出拓扑排序结果
        if(result==1){
            for(int i=0;i<topo.size();i++){
                System.out.println(vertexs[topo.get(i)]+" ");
            }
        }
        
        return result;
    }
    
    public int topoSort(boolean[] visited,LinkedList<Integer> topo){
        //1，计算每个顶点的入度
        int[] inDegree=new int[size];
        for(int i=0;i<size;i++){
            inDegree[i]=0;
            for(int j=0;j<size;j++){
                if(matrix[j][i]!=0&&visited[j]==false){
                    inDegree[i]++;
                }
            }
        }
        
        //2，是否有环标记
        boolean hasCircle=true;
        for(int i=0;i<size;i++){
            if(inDegree[i]==0&&visited[i]==false){//如果一个顶点入度为零且未被排序，则需要加入到队列中，且说明还没有发现环
                hasCircle=false;
                topo.add(i);//加入到队列中
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
    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = new char[][]{
            {'B', 'A'}, 
            {'B', 'D'}, 
            {'A', 'G'},
            {'D', 'E'},
            {'D', 'F'}, 
            {'C', 'F'}, 
            {'C', 'G'}};
        MatrixDG pG;
        // 自定义"图"(输入矩阵队列)
        //pG = new MatrixUDG();
        // 采用已有的"图"
        pG = new MatrixDG(vexs, edges);

        System.out.println(pG.topoSort());        

    }

}
