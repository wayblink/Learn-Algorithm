package com.way.string;


/**
 * Code Interview 1.5
 * @author reus
 *
 */
public class StringCompression {
    
    public static String stringCompression(String str){
        
        if(str==null){
            return null;
        }
        int count =1;
        int len=str.length();
        StringBuffer sb=new StringBuffer();
        String previous=str.substring(0,1);
        String current=null;
        for(int i=1;i<len;i++){
            current=str.substring(i,i+1);
            if(current.equals(previous)){
                count++;
            }else{
                sb.append(previous);
                sb.append(Integer.toString(count));
                count=1;
            }
            previous=current;
        }
        sb.append(previous);
        sb.append(Integer.toString(count));
        
        String newstr=sb.toString();
        if(newstr.length()<str.length()){
            return newstr;
        }
        return str;
        
    }
    
    public static String stringCompression2(String str){
        if(str==null||str.isEmpty()) return null;
        int count=1;
        StringBuffer sb=new StringBuffer();
        char flag=str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==flag){
                count++;
            }else{
                sb.append(flag);
                sb.append(count);
                count=1;
            }
            
        }
        
        String newstr=sb.toString();
        if(newstr.length()<str.length()){
            return newstr;
        }
        return str;
    }
    
    public static void main(String[] args){
        String str="aaaabbccddd";
        String newstr=stringCompression2(str);
        System.out.println(newstr);
    }
}
