package com.way.threads.consumerandproducer;

public class Producer implements Runnable{
    //生产者，负责生产货物
    private Goods goods;
    
    public Producer(Goods goods){
        super();
        this.goods=goods;
        
    }

    public void run() {
        for(int i=0;i<100;i++){
            goods.produce();
        }
    }

}
