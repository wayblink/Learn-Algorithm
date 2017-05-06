package com.way.threads;

/**
 * 
 * @author reus
 * 多线程实现方法1——继承Thread
  1，创建继承Thread类的子类；
  2，在子类中重写Thread的run()方法
  3，调用类的实例的start()方法
 */
public class ThreadHolder extends Thread{
    //1，创建继承Thread类的子类；
    public ThreadHolder(String name){
        this.setName(name);
    }
    //2，在子类中重写Thread的run()方法
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println(this.getName().toString()+"第"+i+"次抢到线程");
        }
        
    }
    
    public static void main(String[] args){
        //3，调用类的实例的start()方法
        ThreadHolder th1=new ThreadHolder("th1");
        ThreadHolder th2=new ThreadHolder("th2");
        th1.start();
        th2.start();
        
    }
    
}
