package com.way.datastruct.list;

public class Queue {
    
    private Node head;
    private Node tail;
    
    //初始化队列
    public Queue(){
        head=tail;
    }
    
    //判断是否为空
    public boolean isEmpty(){
        return head==tail;
    }
    
    //清空队列
    public void clear(){
        head=null;
        tail=head;
    }
    
    //销毁队列
    public void free(Queue q){
        q=null;
    }
    
    //入队
    public void inQueue(Data data){
        Node node=new Node();
        node.nodeData=data;
        node.next=null;
        tail.next=node;
        tail=node;
    }
    
    //出队
    public Data outQueue(){
        Node node=head;
        head=head.next;
        return node.nodeData;
    }

    //读取头元素
    public Data readQueue(){
        return head.nodeData;
    }

    //队列长度
    public int length(){
        int length=0;
        Node temp=head;
        while(temp!=tail){
            length++;
            temp=temp.next;
        }
        return length;
    }
}       
