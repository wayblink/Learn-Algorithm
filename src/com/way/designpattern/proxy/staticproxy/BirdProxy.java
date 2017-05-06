package com.way.designpattern.proxy.staticproxy;

public class BirdProxy {

    private Bird bird;
    
    public BirdProxy(Bird bird){
        this.bird=bird;
    }
    
    public void flyup(){
        System.out.println("before fly");
        bird.up();
        System.out.println("after fly");
    }
    
    public void flydown(){
        System.out.println("before fly");
        bird.down();
        System.out.println("after fly");
    }
}
