package com.way.threads.consumerandproducer;

public class App {

    public static void main(String[] args){
        Goods goods=new Goods();
        //生产消费同时进行，必须保证有商品的时候才能被消费
        Consumer consumer=new Consumer(goods);
        Consumer consumer2=new Consumer(goods);
        Consumer consumer3=new Consumer(goods);
        Producer producer=new Producer(goods);
        Producer producer2=new Producer(goods);
        Producer producer3=new Producer(goods);
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer2).start();
        new Thread(producer2).start();
        new Thread(consumer3).start();
        new Thread(producer3).start();
        
    }
}
