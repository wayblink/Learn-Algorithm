package Exam;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class AliTest {

/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static boolean canhalf(int[] A,int begin,int end) {
        int sum=0;
        for(int i:A){
            sum+=i;
        }
        if(sum%2!=0){
            return false;
        }
        
        int half=sum/2;
        int total=0;
        int i=0;
        while(i<A.length){
            total+=A[i++];
            if(total==half){
                return true;
            }else if(total>half){
                return false;
            }
        }
        return false;
    }
    
    static boolean resolve(int[] A) {
        int sum=0;
        for(int i:A){
            sum+=i;
        }
        if(sum%4!=0){
            return false;
        }
        
        int half=sum/2;
        
        int total=0;
        for(int i=0;i<A.length;i++){
            total+=A[i];
            if(total==half){
                if(canhalf(A,0,i)&&canhalf(A,i+1,A.length-1)){
                    return true;
                } else{
                    return false;
                }
            }else if(total>half){
                return false;
            }
            
        }
        return false;
        
    }
    
    

    public static void main(String[] args){
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while(line != null && !line.isEmpty()) {
            int value = Integer.parseInt(line.trim());
            if(value == 0) break;
            inputs.add(value);
            line = in.nextLine();
        }
        int[] A = new int[inputs.size()];
        for(int i=0; i<inputs.size(); i++) {
            A[i] = inputs.get(i).intValue();
        }
        Boolean res = resolve(A);

        System.out.println(String.valueOf(res));
    }
}
