package Exam;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class test {
    static int secureRand() {  
        final int offset = 123456;  // offset为固定值，避免被猜到种子来源（和密码学中的加salt有点类似）  
        long seed = System.nanoTime() + offset;  
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
    public static void main(String[] args) {
        
        Random r=new Random();
        int redcount=0;
        int bluecount=0;
        
        for(int m=0;m<1000000;m++){
            int red=17;
            int blue=17;
            
            while(red>0&&blue>0){
                int total=red+blue;
                int i=0;int j=0;
                while(i==j||i==0||j==0){
                    i=r.nextInt()%total;
                    j=r.nextInt()%total;  
                }
                
                if(i<=red&&j<=red){
                    red--;
                }else if(i>red&&j>red){
                    red--;
                }else{
                    blue--;
                }
            }
            
            if(red>0){
                redcount++;
            }else{
                bluecount++;
            }
        }
        System.out.println(redcount);
        System.out.println(bluecount);
        
    }

}
