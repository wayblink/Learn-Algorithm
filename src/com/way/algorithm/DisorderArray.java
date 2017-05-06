package com.way.algorithm;

/**
 * 测试数组打乱算法
 * @author reus
 *
 */
public class DisorderArray {
    public static Object[] disorderArray(Object[] objectArr){
        int size=objectArr.length;
        Object temp=null;
        int rand;
        for(int i=0;i<size;i++){
            rand=(int)(Math.random()*size);
            temp=objectArr[i];
            objectArr[i]=objectArr[rand];
            objectArr[rand]=temp;
        }
        return objectArr;
    }
    
    public static void main(String[] args){
        Object[] arr={1,2,3,4,5,6,7,8,9,10};
        arr=DisorderArray.disorderArray(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
