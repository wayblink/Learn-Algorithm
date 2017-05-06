package com.way.algorithm;

/**
 * 约瑟夫环问题
 * @author reus
 *
 */
public class JosepCircle {
    
    public static int[] Josep(int total,int live){
        int[] dieOrder=new int[total];//记录约瑟夫编号，即死亡顺序
        for(int i=0;i<total;i++){//逐个初始化
            dieOrder[i]=0;
        }
        
        int i=0;//游标
        int call=1;//报数
        int die=0;//死亡人数
        
        while(die<total-live){
            if(i==total){
                i=0;//如果到尾回到头，形成环
            }
            if(dieOrder[i]==0){//活人计数
                if(call<3){
                    call++;
                }else{
                    dieOrder[i]=++die;//记录约瑟夫编号
                    System.out.println("第"+die+"个自杀的人是 "+(i+1)+"号");
                    call=1;
                }  
            }
            i++;//移动位置
        }
        
        int[] survive=new int[live];
        int k=0;
        System.out.print("可以活下来的位置是：");
        for(int j=0;j<total;j++){
            if(dieOrder[j]==0){
                System.out.print(j+1+" ");
                survive[k]=j+1;
                k++;
            }
        }
        return survive;
        
    } 
    
    public static int[] hardJosep(int total,int live,int[] no){
        int[] dieOrder=new int[total];//记录约瑟夫编号，即死亡顺序
        for(int i=0;i<total;i++){//逐个初始化
            dieOrder[i]=0;
        }
        
        int i=0;//游标
        int call=1;//报数
        int die=0;//死亡人数
        int callNum=no[0];
        while(die<total-live){
            if(i==total){
                i=0;//如果到尾回到头，形成环
            }
            if(dieOrder[i]==0){//活人计数
                if(call<callNum){
                    call++;
                }else{
                    dieOrder[i]=++die;//记录约瑟夫编号
                    System.out.println("第"+die+"个自杀的人是 "+(i+1)+"号");
                    call=1;
                    callNum=no[i];
                }  
            }
            i++;//移动位置
        }
        
        int[] survive=new int[live];
        int k=0;
        System.out.print("可以活下来的位置是：");
        for(int j=0;j<total;j++){
            if(dieOrder[j]==0){
                System.out.print(j+1+" ");
                survive[k]=j+1;
                k++;
            }
        }
        return survive;
        
    } 
    
    public static void test1(){
        int total=41;
        int live=2;
        int[] dieOrder=new int[total];//记录约瑟夫编号，即死亡顺序
        for(int i=0;i<total;i++){//逐个初始化
            dieOrder[i]=0;
        }
        
        int i=0;//游标
        int call=1;//报数
        int die=0;//死亡人数
        
        while(die<total-live){
            if(i==total){
                i=0;//如果到尾回到头，形成环
            }
            if(dieOrder[i]==0){//活人计数
                if(call<3){
                    call++;
                }else{
                    dieOrder[i]=++die;//记录约瑟夫编号
                    System.out.println("第"+die+"个自杀的人是 "+(i+1)+"号");
                    call=1;
                }  
            }
            i++;//移动位置
        }
        
        System.out.println("约瑟夫环编号：");
        for(int j=0;j<total;j++){
            System.out.println(j+1+" "+dieOrder[j]);
        }
        System.out.print("可以活下来的位置是：");
        for(int j=0;j<total;j++){
            if(dieOrder[j]==0){
                System.out.print(j+1+" ");
            }
        }
    }
    public static void main(String[] args){
        //JosepCircle.Josep(41, 2);
        int[] no=new int[41];
        for(int i=0;i<41;i++){
            no[i]=i+1;
        }
        JosepCircle.hardJosep(41, 2, no);
        
    }

}
