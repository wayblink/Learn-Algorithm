package com.way.threads.consumerandproducer;

public class Consumer implements Runnable{
    //消费者，负责消费货物
    private Goods goods;
    
    public Consumer(Goods goods){
        super();
        this.goods=goods;
    }

    public void run() {

        for(int i=0;i<100;i++){
            goods.consume();
        }
    }
    
}
