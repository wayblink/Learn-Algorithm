package com.way.designpattern.proxy.staticproxy;

public class StaticProxyTest {

    public static void main(String[] args) {
        Bird bird=new Bird();
        BirdProxy bp=new BirdProxy(bird);
        bp.flyup();
        bp.flydown();
    }

}
