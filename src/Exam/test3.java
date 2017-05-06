package Exam;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class test3 {
    static boolean secureRand() {  
        final int offset = 123456;  // offset为固定值，避免被猜到种子来源（和密码学中的加salt有点类似）  
        long seed = System.nanoTime() + offset;  
        SecureRandom sr;  
        try {  
            sr = SecureRandom.getInstance("SHA1PRNG");  
            sr.setSeed(seed);  
            return sr.nextBoolean();  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }   
        return false;  
    }
    public static void main(String[] args){
        Random r=new Random();
        for(int i=0;i<100;i++){
            System.out.println(secureRand());
        }
        
        
    }
}
