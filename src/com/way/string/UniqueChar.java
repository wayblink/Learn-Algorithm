package com.way.string;

public class UniqueChar {

    public boolean isUniqueChars(String str){
        if(str.length()>256){
            return false;
        }
        boolean[] hasChar=new boolean[256];
        for(int i=0;i<str.length();i++){
            int val=str.charAt(i);
            if(hasChar[val]==true){
                return false;
            }else{
                hasChar[val]=true;
            }
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        
    }

}
