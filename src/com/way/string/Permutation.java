package com.way.string;

/**
 * Code Interview 1.3
 * @author reus
 *
 */
public class Permutation {
    
    public static boolean isPermutation(String str1,String str2){
       
        if(str1.length()!=str2.length()){
            return false;
        }
   
        int index=0;
        int len=str1.length();
        while(index<len-1){
            if(str1.charAt(index)!=str2.charAt(len-1-index)){
                return false;
            }
            index++;
        }
        return true;
    }
    
    public static void main(String[] args){
        String str1="abcd";
        String str2="dcba";
        String str3="acbd";
        String str4="abcde";
        
        System.out.println(isPermutation(str1, str4));
//        System.out.println(str1.substring(0, 1));
    }
}
