package com.way.threads.consumerandproducer;

public class Goods {

    private int num=0;
    
    public synchronized void produce(){
        if(isFull()){
            try {
                this.wait();//等待其他进程运行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(!isFull()){
            this.num++;
            System.out.println(Thread.currentThread().getName().toString()+" Produce "+" num: "+num);
            try {
                wait(500);//这里是为了让效果明显，不然太快了，看不出线程的切换
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        
    }
    
    public synchronized void consume(){
        if(isEmpty()){
            try {
                this.wait();//等待其他进程运行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(!isEmpty()){
            this.num--;
            System.out.println(Thread.currentThread().getName().toString()+" Consume "+" num: "+num);
            try {
                wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            
        }
        notifyAll();
    }
    
    public boolean isEmpty(){
        if(num<=0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isFull(){
        if(num>=10){
            return true;
        }else{
            return false;
        }
    }
}
