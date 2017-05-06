package com.way.datastruct.list;

public class LinkList {
    private Node head;
    
    public Node addLast(Data data){
        Node node=new Node();
        node.nodeData=data;
        node.next=null;
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        return head;
    }

    public Node addFirst(Data data){
        Node node=new Node();
        node.nodeData=data;
        node.next=head;
        head=node;
        return head;
    }
    
    public Node find(Data data){
        Node temp=head;
        while(temp!=null){
            if(temp.nodeData.equals(data)){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    
    public Node insert(Data data,Data locationData){
        Node temp=head;
        while(temp!=null){
            if(temp.nodeData.equals(locationData)){
                Node node=new Node();
                node.nodeData=data;
                node.next=temp.next;
                temp.next=node;
                return head;
            }
        }
        return head;
    }
   
    public Node delete(Data data){
        Node temp=head;
        while(temp!=null){
            if(temp.next.nodeData.equals(data)){
                temp.next=temp.next.next;
                return head;
            }
        }
        return head;
    }
    
    public int length(){
        Node temp=head;
        int length=0;;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
    
    public void free(LinkList l){
        l=null;
    }
    
}


