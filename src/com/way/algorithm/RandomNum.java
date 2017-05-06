package com.way.algorithm;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 随机数
 * @author reus
 *
 */
public class RandomNum {

    static double rand(double[] seed){
        double base=256.0;
        double u=16.0;
        double v=123.2;
        
        double temp1,temp2,temp3;
        temp1=u*seed[0]+v;
        temp2=(int)(temp1/base);
        temp3=temp1-temp2*base;
        seed[0]=temp3;
        double random=seed[0]/base;
        return random;
    }
    
    public static int closeRand(int totalNum){
        int random;
        Random randomGenerator=new Random(System.nanoTime());
        random=randomGenerator.nextInt(totalNum);
        return random;
    }
    
    static int secureRand(int n) {  
       final int offset = 123456;  // offset为固定值，避免被猜到种子来源（和密码学中的加salt有点类似）  
       long seed = System.currentTimeMillis() + offset;  
       SecureRandom sr;  
       try {  
           sr = SecureRandom.getInstance("SHA1PRNG");  
           sr.setSeed(seed);  
           return sr.nextInt();  
       } catch (NoSuchAlgorithmException e) {  
           e.printStackTrace();  
       }   
       return 0;  
    }
    
    static void test1(){
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        System.out.println(Math.random());
        Random random=new Random();
        System.out.println(random.nextInt(1000));
        System.out.println(random.nextDouble());
        random.setSeed(12345);
        System.out.println(random.nextInt(1000));
        System.out.println(random.nextInt(1000));
        Random random2=new Random(12345);
        System.out.println(random2.nextInt(1000));
        System.out.println(random2.nextInt(1000));
    }
    
    static void test2(){
        double[] seed={5.0};
        System.out.println(rand(seed));
        System.out.println(rand(seed));
        System.out.println(rand(seed));
        System.out.println(rand(seed)); 
    }
    
    static void test3(){
        for(int i=0;i<100;i++){
            System.out.println(closeRand(1000));
        }
    }
    
    static void test4(){
        for(int i=0;i<100;i++){
            System.out.println(closeRand(1000));
        }
    }
    
    
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        
    }

}
