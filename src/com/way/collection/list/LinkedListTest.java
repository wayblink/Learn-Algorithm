package com.way.collection.list;

public class LinkedListTest {

    private Node first;
    private Node last;
    private int size=0;
    
    public LinkedListTest(){
        first=new Node();
        last=first;
    }
    
    public int size(){
        return size;
    }
    
    public void add(Object obj){
        Node node =new Node();
        node.setData(obj);
        node.setNext(null);
        if(first==null){
            first=node;
        }else{
            node.setPrevious(last);
            last.setNext(node);
            last=node;
        }
        
        size++;
    }
    
    public Object getFirst(){
        return first.getData();
    }
    
    public Object getLast(){
        return last.getData();
    }
    
    public static void main(String[] args){
        LinkedListTest list=new LinkedListTest();
        list.add(10);
        list.add("100");
        System.out.println(list.size());
        System.out.println(list.getLast());
        
    }
    
    
    
}
