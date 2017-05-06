package com.way.sort;

public class SortTest {

 
    public static void main(String[] args){
        
        int[] a={67,65,77,38,97,3,33,49,34};
        //SortUtil.bubbleSort(a);
        //SortUtil.heapSort(a);
        //SortUtil.insertionSort(a);
        SortUtil.quickSort(a,0,a.length-1);
//        SortUtil.selectSort(a);
//        SortUtil.shellSort(a);
        //SortUtil.mergeSort(a);
        SortUtil.printArr(a);
    }
}
