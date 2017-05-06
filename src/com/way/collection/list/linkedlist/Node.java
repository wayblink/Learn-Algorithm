package com.way.collection.list.linkedlist;

public class Node {
    
    public Node next=null;
    public int data;
    
    public Node(){}
    
    public Node(int data){
        this.data=data;
    }
    
    public Node addtotail(int data){
        Node end=new Node(data);
        Node node=this;
        while(node.next!=null){
            node=node.next;
        }
        node.next=end;
        return this;
    }
    
    public Node addtotail(Node end){
        Node node=this;
        while(node.next!=null){
            node=node.next;
        }
        node.next=end;
        return this;
    }
    
    public Node addAfter(int data,int index){
        Node add=new Node(data);
        Node node=this;
        while(node!=null){
            if(node.data==index){
                add.next=node.next;
                node.next=add;
                return this;
            }
        }
        return this;
    }
    
    public Node deleteFirst(int data){
        Node node=this;
        if(node.data==data){
            return this.next;
        }
        while(node!=null){
            if(node.next.data==data){
                node.next=node.next.next;
                return this;
            }
        }
        return this;
    }
    
    public void traverse(){
        Node node=this;
        while(node!=null){
            System.out.println(node.data);
            node=node.next;
        }
    }
    
    public Node removeDuplicate(){
        Node head=this;
        Node node=head;
        /*如果是单节点，直接返回*/
        if(node.next==null){
            return node;
        }
        
        /*不是单节点，继续进行*/
        //记录头结点数据
        int data=head.data;
        
        //当节点有后续节点时，向后移动
        while(node.next!=null){  
            node=node.next;
            //如果节点数据等于头结点数据，抛弃头节点，即对第头节点之后的链表，进行查重，递归调用
            if(data==node.data){
                return head.next.removeDuplicate();
            }
        }
        //如果没有与头节点数据重复的节点，检查后续的节点，但头节点保留
        head.next=head.next.removeDuplicate();
        //返回头节点
        return head;
    }
    
    /**
     * 错误代码

    public Node partition(int index){
        Node head=this;
        if(head.next==null){
            return head;
        }
        if(head.data>=index){
            head=head.addtotail(head.data);
            head=head.next.partition(index);
        }else{
            head.next=head.next.partition(index);
        }
        
        return head;
    }
    */
    
    public Node partition(int index){
        Node less=null;
        Node more=null;
        Node node=this;
        while(node.next!=null){
            if(node.data>=index){
                if(more==null){//判断是否为空，如果为空初始化头节点，如果不为空，向尾部加入
                    more=new Node(node.data);
                }else{
                    more.addtotail(node.data);
                }
            }else{
                if(less==null){
                    less=new Node(node.data);
                }else{
                    less.addtotail(node.data);
                }
            }
            node=node.next;
        }
        return less.addtotail(more);
    }
    
    public static void basicTest(){
        Node node=new Node(1);
        node.addtotail(2);
        node.addtotail(3);
        node.addtotail(4);
        node.traverse();
        node=node.deleteFirst(2);
        node.traverse();
        node.addAfter(0, 1);
        node.traverse();
        node=node.deleteFirst(1);
        node.traverse();
    }
    
    public static void testRemoveDuplicate(){
        Node node=new Node(1);
        node.addtotail(1);
        node.addtotail(2);
        node.addtotail(3);
        node.addtotail(2);
        node.addtotail(4);
        node.addtotail(5);
        node.traverse();
        node=node.removeDuplicate();
        node.traverse();
    }
    
    public static void testPartition(){
        Node node=new Node(4);
        node.addtotail(5);
        node.addtotail(6);
        node.addtotail(3);
        node.addtotail(2);
        node.addtotail(1);
        node.addtotail(5);
        node.traverse();
        System.out.println();
        node=node.partition(3);
        node.traverse();
    }
    
    
    public static void main(String[] args){
        testPartition();
    }
    
}
