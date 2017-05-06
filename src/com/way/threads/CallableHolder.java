package com.way.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author reus
 * Java多线程实现方法：Callable接口实现
 *1，创建实现Callable接口的类,重写run方法；
 *2，创建线程管理器ExcutorService，创建线程；
 *3，实例化实现Callable接口的类
 *4，ExcutorService.submit(类实例)；
 *（5，Callable有返回值，Future result=ser.submit(类实例)；）
 */


//1，创建实现Callable接口的类,重写run方法；
public class CallableHolder implements Callable<Integer>{

    String name;
    int id;
    
    public CallableHolder(String name,int id) {
        this.name=name;
        this.id=id;
    }
    
    @Override
    public Integer call() throws Exception {
        for(int i=0;i<100;i++){
            System.out.println(name+"第"+i+"次抢到线程");
        }
        return id;
    }
    
    
    public static void main(String[] args){
        //2，创建线程管理器ExcutorService，创建线程；
        ExecutorService es=Executors.newFixedThreadPool(2);
        //3，实例化实现Callable接口的类
        CallableHolder ch1=new CallableHolder("ch1", 1);
        CallableHolder ch2=new CallableHolder("ch2", 2);
        //4，ExcutorService.submit(类实例)；
        Future result1=es.submit(ch1);
        Future result2=es.submit(ch2);
        
        try {
            //（5，Callable有返回值，Future result=ser.submit(类实例)；）
            int id1=(int) result1.get();
            int id2=(int) result2.get();
            System.out.println(id1);
            System.out.println(id2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
    }
    
}
