package com.way.designpattern.dynamicproxy;

public class DynamicProxyTest {

    public static void main(String[] args){
        FlyProxy flyProxy=new FlyProxy();
        Fly fly=(Fly) flyProxy.bind(new Bird());
        fly.fly();
    }
}
