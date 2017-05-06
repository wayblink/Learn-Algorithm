package com.way.clazz.classloader;

/**
 * 类的初始化
 * @author reus
 * JVM有且仅有4种情况，必须立即对类进行初始化
 * 1，遇到new，getstatic，putstatic，invokestatic字节码：
 *      使用new实例化对象，
 *      设置或使用类的静态字段（final除外，已在编译器放到常量池中）
 *      调用一个类的静态方法
 * 2，对类进行反射调用时
 * 3，初始化子类，父类也会被初始化
 * 4，虚拟机启动时，main所在的入口类
 */
public class PassiveInit {
    
    public static void main(String[] args){
       test3();
    }
    
    static void test1(){
        System.out.println(SubClass.value1);//调用子类的变量，父类子类都会初始化
        //System.out.println(SubClass.value2);//调用父类的静态变量，子类不会初始化
        //System.out.println(SubClass.value3);//初始化子类一定会初始化父类
    }
    
    static void test2(){
        SuperClass[] scs=new SuperClass[5];
        System.out.println(scs.getClass());//创数组不会初始化类，因为数组直接继承于Object的子类
    }
    
    static void test3(){
        System.out.println(ConstClass.HELLO_WORLD);//在类编译期间就加载到常量池的常量，不会引起类的初始化
    }
    
    
}

class SuperClass{
    
    static{
        System.out.println("Super class is initialized");
    }
    
    static int value1=1;
    static int value2=2;
}

class SubClass extends SuperClass{
    
    static{
        System.out.println("Sub Class is initialized");
    }
    
    static int value1=-1;
    static int value3=-3;
}

class ConstClass{
    static{
        System.out.println("Const Class is initialized");
    }
    public static final String HELLO_WORLD="hello world";
}
