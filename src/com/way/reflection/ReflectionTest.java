package com.way.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Java反射机制学习
 * @author reus
 * 当程序运行时，允许改变程序结构或变量类型，这种语言称为动态语言。
 * 我们认为java并不是动态语言，但是它却有一个非常突出的动态相关机制，俗称：反射。
 * 
 * 反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
 * 对于任意一个对象，都能够调用它的任意一个方法和属性；
 * 这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
 * 
 * 反射机制主要提供了以下功能： 

                1，在运行时判断任意一个对象所属的类；

                2，在运行时构造任意一个类的对象；

                3，在运行时判断任意一个类所具有的成员变量和方法；

                4，在运行时调用任意一个对象的方法；

                5，生成动态代理。
 */

public class ReflectionTest {

    public static void main(String[] args) {
        test9();
        
    }
    
    //第一个实验，了解Class类的概念,Java中"万物皆为class",java.lang包中的位置说明了他的大佬地位
    //本实验，将会练习如何动态获得一个对象或者一个类的类名，让你更将深入地了解Class
    static void test1(){
        F f=new F();//定义和初始化一个类对象
        Class c1=F.class;//定义一个Class对象，初始化为F.class，
                        //很多博客在这一点上解释为，class是F的一个静态变量，或者说每一个类都有一个隐式的class域
                        //这似乎挺对，也有助于理解，然而我有点不同意见，
                        //如果class是一个静态变量，那么它的实例也有这个变量，然而实际上，当我输入Class c2=f.class的时候,是会报错的
                        //因此我认为这句话就是把F.class本身的实体赋予了c1，在Java编译时就加载进去.
        Class c2=f.getClass();//通过实例对象的getClass方法也可以得到类的实体，值得说明的是这个getClass()是Object类的方法，返回这个对象的类型类（好绕啊）
                        //有趣吧，由此我们更深地了解“万物皆为class”这句话，Class is a class！！
        Class c3=null;
        try {
            c3=Class.forName("com.way.reflection.F");//第三种获取类型类的方式Class.forClass("XXXX")
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c1);
        System.out.println(f.getClass().getClass());
        System.out.println(c3);
        System.out.println(c1==c2);
        System.out.println(c2==c3);//从这里看出绝对地址相同，指向同一个东西
    }
    
    //通过类型类来初始化实例
    static void test2(){
        Class c=F.class;
        F f=null;
        try {
            f=(F)c.newInstance();//newInstance是Class类的方法，返回一个新的泛型对象，强制转型为F对象
                                 //这句话如果改为f=f.getClass().newInstance()不需要转型
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(f);
        System.out.println(f.getClass());
        System.out.println(f.getClass().getName());
    }
    
    //为了加深实验二印象，做了实验三，发现重新初始化前后的绝对地址发生变化，确定确实初始化了一个新实例，改变了f的引用
    static void test3(){
        F f=new F();
        System.out.println(f);
        try {
            f=f.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(f);
    }
    
    //实验四，
    static void test4(){
        Class c1=String.class;
        Object c2=void.class;
        Class c3=void.class;
        Class c4=int.class;
        System.out.println(c1.getName());//通过Class的getName方法可以获得类的名称，

        System.out.println(c1.getSimpleName());//getSimpleName获取不含包完整路径的类名
        
        System.out.println(c2.getClass().getName());//如果是对象需要先获得为对应的类型类

        System.out.println(c3.getName());//我们会发现void也有一个类型

        System.out.println(c4.getName());//int是基本数据类型，没有所属的包，void也是如此
    }
    

    //实验五，动态获取类型方法
    public static void test5(){
        ReflectionTest rt=new ReflectionTest();
        Method[] ms=rt.getClass().getMethods();//Class的getMethods()方法，返回类型的所有共有方法
        for(Method m:ms){
            System.out.println(m);
            System.out.println(m.getName());//method.getName()获取方法名
            Class returnType=m.getReturnType();//method.getReturnType()获取返回参数类型
            System.out.println(returnType);
            System.out.println(returnType.getName());//获取返回参数类型的名字
            Class[] parameters=m.getParameterTypes();//method.getParameters获取方法传入参数的类型
            for(Class p:parameters){
                System.out.print(p+",");
            }
            System.out.println();
        }
    }
    
    //实验五的辅助函数，
    //这个函数的返回类型输出如下：int,class [I,class [D,class [Ljava.lang.String;,class [Lcom.way.reflection.F;,
    //我们会发现任何"数组"也是一种类型，前面会有class [L这样的标志
    public static int test5add(int a,int[] b,double[] c,String[] d,F[] e){
        return 0;
    }
   
    //实验六，获取成员变量
    static void test6(){
        F ff=new F("test",1);
        Class c=F.class;
        Field[] fields=c.getFields();
        for(Field f:fields){
                try {
                    System.out.println(f.get(ff));//field.get(Object obj)获取对象的对应成员变量对象(Object)
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                System.out.println(f.getType());//field.获取类型成元变量的类型类
            
        }
    }
    
    //实验七
    static void test7(){
        Class c=F.class;
        Constructor[] cs=c.getConstructors();
        for(Constructor constructor:cs){
            System.out.println(constructor.getName());
            Class[] parameters=constructor.getParameterTypes();
            if(parameters.length==0){
                System.out.println("No parameter constructor");
            }else{
                for(Class parameter:parameters){
                    System.out.println(parameter.getName());
                }
            }
        }
    }

    //实验8，测试Declared的get方法
    static void test8(){
        Class c=null;
        try {
            c=Class.forName("com.way.reflection.F");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        System.out.println(c.getMethods().length);
        System.out.println(c.getDeclaredMethods().length);
        
    }
    
    static void test9(){
        Class c=null;
        try {
            c=Class.forName("com.way.reflection.F");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ClassLoader cl=c.getClassLoader();
        System.out.println(cl);
        
        Integer i=new Integer(1);
        String s=new String("1");
        ArrayList<String> list=new ArrayList<>();
        System.out.println(i.getClass().getClassLoader());
        System.out.println(s.getClass().getClassLoader());
        System.out.println(list.getClass().getClassLoader());
        
    }
}

class F extends Thread{
    public String name;
    public int id;
    public F(){
        
    }
    public F(String name,int id){
        this.name=name;
        this.id=id;
    }
} 


