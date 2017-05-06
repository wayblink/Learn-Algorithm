package com.way.threads;
/**
 * 
 * @author reus
 * Java多线程实现方式：实现Runnable接口
 *1，创建实现Runnable接口的类,重写run方法
 *2，创建真实对象，即实例化类
 *3，创建代理：Thread对象，并引用是指真实对象
 *4，代理.start();
 */
//1，创建实现Runnable接口的类
public class RunnableHolder implements Runnable{
    String name;
    
    public RunnableHolder(String name){
        this.name=name;
    }
    //重写run方法
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(name+"第"+i+"次抢到线程");
        }
    }
    
    public static void main(String[] args){
        //创建真实对象，即实例化类
        RunnableHolder rh1=new RunnableHolder("rh1");
        RunnableHolder rh2=new RunnableHolder("rh2");
        //创建代理：Thread对象，并引用是指真实对象
        Thread thread1=new Thread(rh1);
        Thread thread2=new Thread(rh2);
        //代理.start();
        thread1.start();
        thread2.start();
    }
    
}
