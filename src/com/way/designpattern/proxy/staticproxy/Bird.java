package com.way.designpattern.proxy.staticproxy;

public class Bird implements Fly{

    public void up(){
        System.out.println("Bird is flying up");
    }
    
    public void down(){
        System.out.println("Bird is flying down");
    }
}
