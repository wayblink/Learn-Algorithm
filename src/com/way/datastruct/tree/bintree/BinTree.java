package com.way.datastruct.tree.bintree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class BinTree {

    public int data;
    public BinTree left;
    public BinTree right;
    
    public BinTree(){
        
    }
    public BinTree(int data){
        this.data=data;
    }
    
    //根据数组创建完全二叉树
    public static BinTree createTree(int[] arr){
        int count=0;
        int length=arr.length;
        BinTree root=new BinTree(arr[count++]);
        LinkedList<BinTree> queue=new LinkedList<BinTree>();
        queue.add(root);
        
        while(count<length){
            BinTree lastNode=queue.poll();
            if(count<length){
                lastNode.left=new BinTree(arr[count++]);
                queue.add(lastNode.left);
            }
            if(count<length){
                lastNode.right=new BinTree(arr[count++]);
                queue.add(lastNode.right);
            }
        }
        return root;
    }        
        
    //前序遍历，返回数列
    public ArrayList<Integer> preorderTraverse(){
        BinTree root=this;
        ArrayList<Integer> list=new ArrayList<Integer>();
        
        list.add(root.data);
        
        if(root.left!=null){
            list.addAll(root.left.preorderTraverse());
        }
        if(root.right!=null){
            list.addAll(root.right.preorderTraverse());
        }
        return list;
    }
    
    //中序遍历，返回数列
    public ArrayList<Integer> midorderTraverse(){
        BinTree root=this;
        
        ArrayList<Integer> list=new ArrayList<Integer>();
        
        if(root.left!=null){
            list.addAll(root.left.midorderTraverse());
        }
        list.add(root.data);
        if(root.right!=null){
            list.addAll(root.right.midorderTraverse());
        }
        
        return list;
    }
    
    //后序遍历返回数列
    public ArrayList<Integer> afterorderTraverse(){
        BinTree root=this;
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(root.left!=null){
            list.addAll(root.left.afterorderTraverse());
        }
        if(root.right!=null){
            list.addAll(root.right.afterorderTraverse());
        }
        list.add(root.data);
        return list;
    }
    
    public ArrayList<Integer> preorderTraverse2(){
        
        BinTree node=this;
        ArrayList<Integer> list=new ArrayList<Integer>();
        Stack<BinTree> s = new Stack<BinTree>();    
        
        while (node != null || !s.empty()) {    
            while (node != null) {
                list.add(node.data);
                s.push(node);    
                node = node.left;    
            }    
            if (!s.empty()) {    
                node = s.pop();    
                node = node.right;    
            }    
        } 
        
        return list;
    }
    
    public ArrayList<Integer> midorderTraverse2(){
        BinTree node =this;
        ArrayList<Integer> list =new ArrayList<Integer>();
        Stack<BinTree> s=new Stack<BinTree>();
        
        while(node!=null||!s.isEmpty()){
            while(node!=null){
                s.push(node);
                node=node.left;
            }
            if(!s.empty()){
                node=s.pop();
                list.add(node.data);
                node=node.right;
            }
        }
        return list;
    }
    
    public ArrayList<Integer> afterorderTraverse2(){
        BinTree node =this;
        ArrayList<Integer> list =new ArrayList<Integer>();
        Stack<BinTree> s=new Stack<BinTree>();
        
        Stack<Integer> s2 = new Stack<Integer>();    
        Integer i = new Integer(1);    
        while (node!= null || !s.empty()) {    
            while (node != null) {    
                s.push(node);    
                s2.push(new Integer(0));    
                node = node.left;    
            }    
            while (!s.empty() && s2.peek().equals(i)) {    
                s2.pop();    
                list.add(s.pop().data);
            }    
    
            if (!s.empty()) {    
                s2.pop();    
                s2.push(new Integer(1));    
                node = s.peek();    
                node = node.right;    
            }    
        } 
        return list;
    }
    
    public ArrayList<Integer> MorrisTraverse() {  
        ArrayList<Integer> list = new ArrayList<Integer>();  
        BinTree root=this;
          
        BinTree node = root;  
        while(node != null) {  
            if(node.left == null) {  
                list.add(node.data);  
                node = node.right;  
            } else {  
                BinTree tmp = node.left;  
                while(tmp.right != null && tmp.right != node)  
                    tmp = tmp.right;  
                if(tmp.right == null) {  
                    tmp.right = node;  //找到当前节点的前驱节点  
                    node = node.left;  
                } else {  
                    list.add(node.data);  
                    tmp.right = null;  //恢复二叉树  
                    node = node.right;  
                }  
            }  
        }  
        return list;  
    } 
    
    public ArrayList<Integer> levelTraverse() {
  
        BinTree root=this;
        LinkedList<BinTree> queue = new LinkedList<BinTree>();  
        ArrayList<Integer> list=new ArrayList<Integer>();
        BinTree current = null;  
        queue.add(root);//将根节点入队  
        while(!queue.isEmpty())  
        {  
            current = queue.poll();//出队队头元素并访问  
            list.add(current.data);
            if(current.left != null)//如果当前节点的左节点不为空入队  
            {  
                queue.add(current.left);  
            }  
            if(current.right != null)//如果当前节点的右节点不为空，把右节点入队  
            {  
                queue.add(current.right);  
            }  
        }  
        return list;
    }  
    
    public static void main(String[] args){
        //创建一个二叉树
        int[] arr=new int[100000];
        for(int i=0;i<arr.length;i++){
            arr[i]=i;
        }
        BinTree tree=BinTree.createTree(arr);
        
        //创建一个线性表存储遍历结果
        ArrayList<Integer> list=new ArrayList<Integer>();
        
        //起始时间计时
        long start;
        long end;
        
        //统计每种方法的总时间
        long time1,time2,time3,time4,time5,time6,time7,time8;
        time1=0;
        time2=0;
        time3=0;
        time4=0;
        time5=0;
        time6=0;
        time7=0;
        time8=0;
        
        for(int i=0;i<100;i++){
            //递归前序
        start = System.nanoTime();
        list=tree.preorderTraverse();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time1+=(end-start);
            //递归中序遍历
        start = System.nanoTime();
        list=tree.midorderTraverse();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time2+=(end-start);
        
        //递归后序
        start = System.nanoTime();
        list=tree.afterorderTraverse();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time3+=(end-start);
        
        //非递归前序
        start = System.nanoTime();
        list=tree.preorderTraverse2();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time4+=(end-start);
        
        //非递归中序
        start = System.nanoTime();
        list=tree.midorderTraverse2();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time5+=(end-start);
        
        //非递归后序
        start = System.nanoTime();
        list=tree.afterorderTraverse2();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time6+=(end-start);
        
        //非递归层序
        start = System.nanoTime();
        list=tree.levelTraverse();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time7+=(end-start);
        
        //Morris中序遍历
        start = System.nanoTime();
        list=tree.MorrisTraverse();
        //System.out.println(list.toString());
        end = System.nanoTime();
        //System.out.println(end-start);
        time8+=(end-start);
        }
        
        System.out.println("递归前序：     "+time1);
        System.out.println("递归中序：     "+time2);
        System.out.println("递归后序：     "+time3);
        System.out.println("非递归前序： "+time4);
        System.out.println("非递归中序： "+time5);
        System.out.println("非递归后序： "+time6);
        System.out.println("非递归层序： "+time7);
        System.out.println("Morris：   "+time8);
    }
    
}
