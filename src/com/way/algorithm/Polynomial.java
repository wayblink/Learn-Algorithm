package com.way.algorithm;

import java.util.EnumMap;

import com.way.algorithm.Polynomial.DIV;

public class Polynomial {

    /**
     * 计算多项式的值
     * 内部逻辑是一个简单递归
     * @param para 多项数参数组成的数组 para[0]是常数项，para[1]是一次项，以此类推
     * @param x 变量的数值
     * @return 变量值对应的多项式值
     */
    public static double polynomial1D(double[] para,double x){
        double result=0;
        for(int i=para.length-1;i>=0;i--){
            result=result*x+para[i];
        }
        return result;
    }
    
    /**
     * 计算二元多项式的值
     * 将整个计算分成两步，第一步计算一个变量的多项式值，第二步乘上另一个变量
     * @param para 二元多项式的系数二维数组
     * @param x 变量1
     * @param y 变量2
     * @return 计算数值
     */
    public static double polynomial2D(double[][] para,double x,double y){
        double result=0;
        int nx=para.length;
        for(int i=nx-1;i>=0;i--){
            result=result*x+polynomial1D(para[i],y);
        }
        return result;
    }
    
    /**
     * 多项式乘法
     * @param a
     * @param b
     * @return 相乘后的多项式系数数组
     */
    public static double[] polynomial_mul(double[] a,double[] b){
        int na=a.length;
        int nb=b.length;
        double[] r=new double[na+nb-1];//新建一个乘积多项式参数数组，数组元素的个数是na+nb-1
        for(int i=0;i<na+nb-1;i++){
            r[i]=0.0;//逐个初始化
        }
        for(int j=0;j<na;j++){
            for(int k=0;k<nb;k++){
                r[j+k]+=a[j]*b[k];//逐个相乘，累加
            }
        }
        
        return r;
    }
    
    /**
     * 多项式除法
     * @param a 被除多项式
     * @param b 除数多项式
     * @param r 商多项式
     * @param l 余数多项式
     * 综合除法
     */
    
    public static void polynomial_div(double[] a,double[] b,double[] r,double[] l){
        int na=a.length;
        int nb=b.length;
        int nr=r.length;
        int nl=l.length;
        int ta,tb;
        ta=na-1;
        for(int i=0;i<nr;i++){
            r[i]=0.0;
        }
        for(int i=nr;i>0;i--){
            r[i-1]=a[ta]/b[nb-1];
            tb=ta;
            for(int j=1;j<=nb-1;j++){
                a[tb-1]-=r[i-1]*b[nb-j-1];
                tb-=1;
            }
            ta-=1;
        }
        for(int i=0;i<nl;i++){
            l[i]=a[i];
        }
        
    } 
    
    public enum DIV{
        SHANG,YUSHU;
    }
    /**
     * 多项式除法另一种实现，返回由商和余数多项式系数数组组成的EnumMap
     * 这样做是为了解决同时输出两个对象的需求，好处是不需要在调用方法时认为定义并计算商和余数多项数参数数组
     * EnumMap比较少见，实质上实现和定义一个处罚结果类相似
     * 代码依然不算优雅
     * @param a
     * @param b
     * @return
     */
    public static EnumMap<DIV, double[]> polynomial_div(double[] a,double[] b){
        int na=a.length;
        int nb=b.length;
        int nr=na-nb+1;
        int nl=nb-1;
        
        double[] r=new double[a.length-b.length+1];
        double[] l=new double[b.length-1];
        int ta,tb;
        ta=na-1;
        for(int i=0;i<nr;i++){
            r[i]=0.0;
        }
        for(int i=nr;i>0;i--){
            r[i-1]=a[ta]/b[nb-1];
            tb=ta;
            for(int j=1;j<=nb-1;j++){
                a[tb-1]-=r[i-1]*b[nb-j-1];
                tb-=1;
            }
            ta-=1;
        }
        for(int i=0;i<nl;i++){
            l[i]=a[i];
        }
        
        EnumMap<DIV,double[]> enumMap=new EnumMap<DIV, double[]>(DIV.class);
        enumMap.put(DIV.SHANG, r);
        enumMap.put(DIV.YUSHU, l);
        return enumMap;
    }
    
    /**
     * 测试一元多项式计算
     */
    public static void test1(){
        double a[]={1,2,3};
        System.out.println(polynomial1D(a,2)); 
    }
    
    /**
     * 测试二元多项式计算
     */
    public static void test2(){
        double b[][]={{1,2,3},{4,5,6}};
        System.out.println(polynomial2D(b, 1, 2));
    }
    
    /**
     * 测试多项式乘法
     */
    public static void test3(){
        double a[]={1,2,3};
        double b[]={3,2,6};
        double[] r=polynomial_mul(a, b);
        for(double d:r){
            System.out.println(d);
        }
    }
    
    /**
     * 测试多项式除法
     */
    public static void test4(){
        double[] m={-3,6,-3,4,2};
        double[] n={-1,1,1};
        
        double[] rr=new double[m.length-n.length+1];
        double[] ll=new double[n.length-1];
        polynomial_div(m,n,rr,ll);
        for(double d:rr){
            System.out.print(d+" ");
        }
        System.out.println();
        for(double d:ll){
            System.out.print(d+" ");
        }
        System.out.println();
    }
    
    /**
     * 测试多项式除法
     */
    public static void test5(){
        double[] m={-3.5,6.4,-3,4,2};
        double[] n={-1,1.2,1};
        
        EnumMap<DIV, double[]> divResultMap=polynomial_div(m,n);
        double[] rr=(double[]) divResultMap.get(DIV.SHANG);
        double[] ll=(double[]) divResultMap.get(DIV.YUSHU);
        for(double d:rr){
            System.out.print(d+" ");
        }
        System.out.println();
        for(double d:ll){
            System.out.print(d+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        
        test1();
        test2();
        test3();
        test4();
        test5();
        

    }
    
}