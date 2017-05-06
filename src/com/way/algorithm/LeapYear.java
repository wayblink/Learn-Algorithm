package com.way.algorithm;

public class LeapYear {

    /**
     * 判断闰年
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year){
        if(year%4==0&&year%100!=0||year%400==0){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(isLeapYear(4));
        System.out.println(isLeapYear(8));
        System.out.println(isLeapYear(100));
        System.out.println(isLeapYear(400));
        
    }

}
