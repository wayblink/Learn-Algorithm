package com.way.datastruct.list;

public class SequenceList {
    //顺序表最大长度
    static final int MAXLEN=100;
    private Data[] DataList=new Data[MAXLEN];
    private int ListLength; 
    
    //初始化方法，确保空间内全为空
    public SequenceList(){      
        for(int i=0;i<MAXLEN;i++){
            this.DataList[i]=null;
        }
    }
    
    //长度获取
    public int getLength(){
        return this.ListLength;
    }
    
    //是否为空
    public boolean isEmpty(){
        if(this.ListLength==0){
            System.out.println("为空");
            return true;
        }else{
            return false;
        }
    }
    
    //是否已满
    public boolean isFull(){
        if(this.ListLength==MAXLEN){
            System.out.println("已满");
            return true;
        }else{
            return false;
        }
    }
    
    //在指定位置插入元素
    public int insert(int location,Data InsertData){
        if (this.getLength()>=MAXLEN){
            System.out.println("超出长度");
            return 0;
        }
        if(location<1||location>this.getLength()+1){
            System.out.println("插入位置不合理");
            return 0;
        }
        for (int i=this.ListLength;i>location-1;i--){
            this.DataList[i]=this.DataList[i-1];
        }
        this.DataList[location-1]=InsertData;
        this.ListLength++;
        return 1;
    }
    
    //在头插入元素
    public int addfirst(Data data){
        this.insert(1, data);
        return 1;
    }
    
    //在队尾插入元素
    public int addlast(Data data){
        this.insert(this.ListLength+1, data);
        return 1;
    }
    
    //删除指定数据
    public int delete(Data data){
        for (int i=0;i<this.ListLength;i++){
            if(this.DataList[i].equals(data)){
                for(int j=i;j<this.ListLength-1;j++){
                    this.DataList[j]=this.DataList[j+1];
                }
                this.ListLength--;
                return 1;
            }
            
        }
        System.out.println("没有这一元素");
        return 0;
    }
    
    //删除指定位置的数据
    public int delete(int location){
        if(location<1||location>this.ListLength){
            System.out.println("位置超出范围");
            return 0;
        }
        for(int i=location-1;i<this.ListLength-2;i++){
            this.DataList[i]=this.DataList[i+1];
        }
        this.ListLength--;
        return 1;
    }
    
    //删除第一个元素
    public int deletefisrt(){
        if(this.isEmpty()){
            return 0;
        }
        for(int i=0;i<this.ListLength-1;i++){
            this.DataList[i]=this.DataList[i+1];
        }
        this.ListLength--;
        return 1;
    }
    
    //删除最后一个元素
    public int deletelast(){
        if(this.isEmpty()){
            return 0;
        }
        this.DataList[this.ListLength-1]=null;
        this.ListLength--;
        return 1;
    }
    
    //按内容查找查找元素位置
    public int find(Data data){
        if(this.isEmpty()){
            return 0;
        }
        for (int i=0;i<this.ListLength;i++){
            if(this.DataList[i].equals(data)){               
                return i;
            }          
        }
        return 0;
    }
    
    //按位置查找元素内容
    public Data getData(int location){
        if(location<1||location>this.ListLength){
            System.out.println("No this location");
            return null;
        }
        return this.DataList[location-1];
    }
    
  //清空表
    public void clear(){
        for(int i=ListLength;i>0;i--){
            DataList[i-1]=null;
        }
        ListLength=0;
    }
    
    //销毁表  ，销毁和清空是不一样的
    public void free(SequenceList s){
        if(s!=null){
            s=null;
        }
    }

}



