package com.way.string;

/**
 * Code Interview 1.4
 * @author reus
 *
 */
public class Trim {

    public static String change(String str){
        int len=str.length();
        boolean previous=false;
        boolean current=false;
        StringBuffer sf=new StringBuffer();
        for(int i=0;i<len;i++){
            String s=str.substring(i, i+1);
            if(s.equals(" ")){
                current=true;
            }else{
                current=false;
                if(previous==true){
                    sf.append("%20").append(s);
                }else if(previous==false){
                    sf.append(s);
                }
            }
            previous=current;
        }
        return sf.toString();
    }
    
    String replaceSpaces(String str){
        int len=str.length();
        int spaceCount=0;
        for(int i=0;i<len;i++){
            if(str.charAt(i)==' '){
                spaceCount++;
            }
        }
        int newlength=len+spaceCount*2;
        char[] charArray=new char[newlength];
        for(int j=len-1;j>0;j--){
            if(str.charAt(j)==' '){
                charArray[newlength--]='0';
                charArray[newlength--]='2';
                charArray[newlength--]='%';
            }else{
                charArray[newlength--]=str.charAt(j);
            }
        }
        
        return new String(charArray);
    }
    
    public static void main(String[] args) {
        String str="Mr John Smith   G";
        System.out.println(change(str));

    }

}
