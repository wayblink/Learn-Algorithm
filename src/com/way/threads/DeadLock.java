package com.way.threads;

public class DeadLock {
    
    public static void main(String[] args) throws InterruptedException{
        Object obj1=new Object();
        Object obj2=new Object();
        Object obj3=new Object();
        Thread t1=new Thread(new SyncThread(obj1,obj2),"thread1");
        Thread t2=new Thread(new SyncThread(obj2,obj3),"thread2");
        Thread t3=new Thread(new SyncThread(obj3,obj1),"thread3");
    
        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        t3.start();
    }
    
}

class SyncThread implements Runnable{
    Object obj1;
    Object obj2;
    
    public SyncThread(Object obj1,Object obj2){
        this.obj1=obj1;
        this.obj2=obj2;
    }
    
    public void run(){
        String name=Thread.currentThread().getName();

            System.out.println(name+" begin to run");
            synchronized(obj1){
                System.out.println(name +" is using "+obj1);
                System.out.println(name+" want "+obj2);
                work();
                
                synchronized (obj2) {
                    System.out.println(name +" is using "+obj2);
                    work();
                }
                System.out.println(name +" release "+obj2);
            }
            System.out.println(name +" release "+obj1);
            System.out.println(name+" finish runing");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    
    public void work(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
}
