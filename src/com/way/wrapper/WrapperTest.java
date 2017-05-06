package com.way.wrapper;

public class WrapperTest {

    public static void main(String[] args){
        
        Integer a=1;
        Number n;
        Character c='c';
        char cc=c;
        Boolean b;
        System.out.println(a.equals(1));
        Object o;
    }

    public static<T> int value(T arr){
        return (int)arr;
    }
}
