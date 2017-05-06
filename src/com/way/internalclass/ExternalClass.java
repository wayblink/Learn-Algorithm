package com.way.internalclass;

public class ExternalClass {
    
    int val1=1;
    
    static int val2=2;
    class InternalClass{
        public void call(){
            System.out.println(val2);
        }
    }
    
    public void call(){
        InternalClass ic=new InternalClass();
        ic.call();
    }
    
    public void test(){
        System.out.println(val1);
    }

    public static void main(String[] args) {
        ExternalClass ec=new ExternalClass();
        ec.call();
    }

}
