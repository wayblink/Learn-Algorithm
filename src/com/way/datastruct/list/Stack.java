package com.way.datastruct.list;

public class Stack {
    
    private Data[] data;//以数组或者说顺序表的形式来实现栈，其实也可以用链表来实现
    private Data top;//定义栈顶
    private int maxSize;//栈的最大容量
    private int size;//栈的数据量
    
    public Stack(int maxSize){//栈初始化
        if((this.data=new Data[maxSize]) != null){//尝试开辟内存，如果系统内存不够，可能失败
            this.top=this.data[0];
            this.maxSize=maxSize;
            this.size=0;
        }
    }
    
    //判断是否为空
    public boolean isEmpty(){
        return top==null;
    }
    
    //判断是否满栈
    public boolean isFull(){
        if(size==maxSize){
            System.out.println("Full");
            return true;
        }
        return false;
    }
    
    //入栈
    public Stack push(Data data){
        if(!isFull()){
            this.data[size]=data;
            size++;
            return this;
        }
        return this;
    }

    //出栈
    public Data pop(){
        if(!isEmpty()){
            Data popData=this.data[size-1];
            this.data[size-1]=null;
            this.size--;
            return popData;
        }
        return null;
    }
    
    //读取栈，读取指的是读栈顶元素，和出栈的不同是读取不会弹出栈顶元素。
    public Data read(){
        return this.data[size-1];
    }

    //清空栈
    public void clear(){
        for(int i=size;i>0;i--){
            data[i-1]=null;
        }
        top=data[0];
        size=0;
    }
    
    //销毁栈  ，销毁和清空是不一样的
    public void free(Stack s){
        if(s!=null){
            s=null;
        }
    }
    
    //栈元素数量
    public int size(){
        return size;
    }
    
    public static void main(String args[]){
        
        Stack stack=new Stack(100);
        Data data=new Data();
        data.id=1;
        data.head="2";
        data.body="3";
        stack.push(data);
        System.out.println(stack.read().id);
        stack.free(stack);
        System.out.println(stack.top.id);
       
    }
    
}
