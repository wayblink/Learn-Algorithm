package com.way.jvm.memory;

public class InternTest {

    public static void main(String[] args){

        test1();
        
        test2();
       
    }
    
    static void test1(){
        System.out.println("Test1");
        System.out.println("---------------");
        
        int i=1;
        int j=i;
        System.out.println(i==j);
        j++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(i==j);
        
        System.out.println("---------------");
        System.out.println();
    }
    
    static void test2(){
        System.out.println("Test2");
        System.out.println("---------------");
        
        String s1=new String("1");
        String s2=new String("1");
        String s3="1";
        String s4="1";
        
        System.out.println(s1==s2);
        System.out.println(s3==s3);
        
        s3="2";
        System.out.println(s1==s2);
        System.out.println(s4==s3);
        
        System.out.println("---------------");
        System.out.println();
    }
    
    static void test3(){
        String s0=new String("1");
        String s1=new String("1");
        String s2="1";
        String s3=s1.intern();
        String s4=s1;
        s0.intern();
        
        System.out.println(s1==s0);
        System.out.println(s0==s2);
        System.out.println(s1==s2);
        System.out.println(s2==s3);
        System.out.println(s3==s1);
        System.out.println(s1==s4);
        System.out.println(s4==s2);
    }
}
