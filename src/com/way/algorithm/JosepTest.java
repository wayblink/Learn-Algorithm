package com.way.algorithm;

public class JosepTest {

    public static void main(String[] args) {

        double[] dieOrder=new double[41];
        for(int i=0;i<dieOrder.length;i++){
            dieOrder[i]=-1;
        }
        
        int live=41;
        int call=1;
        int i=0;
        while(live>2){
            if(dieOrder[i]<0){
                if(call==3){
                    dieOrder[i]=41-live+1;
                    call=1;
                    live--;
                }else{
                    call++;
                }
            }
            i++;
            if(i==41){
                i=0;
            }
        }
        
        for(int j=0;j<41;j++){
            System.out.println(j+1+" "+dieOrder[j]);
        }
        
        
        java.util.Arrays.sort(dieOrder);
        for(int j=0;j<41;j++){
            System.out.println(j+1+" "+dieOrder[j]);
        }
    }

}
