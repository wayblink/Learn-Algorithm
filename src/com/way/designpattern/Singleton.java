package com.way.designpattern;

/**
 * 演示单例设计模式
 * @author reus
 * 1，私有化构造器，避免外部直接创建
 * 2，声明私有静态的类对象，初始设置为空
 * 3，创建对外的静态方法，判断对对象是否为空，如果为空，调用私有的创建方法
 * *用synchronized关键词强化安全性
 */

public class Singleton {

    //1，私有化构造器，避免外部直接创建
    private Singleton(){
        
    }

    //2，声明私有静态的类对象，初始设置为空
    private static Singleton instance=null;
    
    //3，创建对外的静态方法，判断对对象是否为空，如果为空，调用私有的创建方法
    public static Singleton getInstance(){
        if(instance==null){//已经有实例，直接返回，提高效率
            synchronized (Singleton.class) {//*用synchronized关键词强化安全性
                if(instance==null){//确保安全性
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
    
}

/**
 * 演示单例设计模式
 * @author reus
 * 1，饿汉式实现：在类中声明静态类对象时直接初始化了一个实例
 * 2，在对外的实例方法中，直接返回已实例化对象
 */

class Singleton2 {

    private Singleton2(){        
    }

    //1，声明私有静态的类对象——饿汉式实现：在类中声明静态类对象时直接初始化了一个实例
    private static Singleton2 instance=new Singleton2();
    
    //2，创建对外的静态方法，判断对对象是否为空，如果为空，调用私有的创建方法
    public static Singleton2 getInstance(){       
        return instance;
    }
    
}

/**
 * 演示单例设计模式
 * @author reus
 * 1，饿汉式实现：在类中声明静态类对象时直接初始化了一个实例
 * 2，在对外的实例方法中，直接返回已实例化对象
 */

class Singleton3 {

    //把实例包装在一个类里面，这样在Singleton只有一个SingletonHolder类的引用，只有在真正外部实例化的时候，才会开辟空间，创建单例的对象
    private static class Singleton3Holder{
        //1，声明私有静态的类对象——饿汉式实现：在类中声明静态类对象时直接初始化了一个实例
        private static Singleton3 instance=new Singleton3(); 
    }
    private Singleton3(){        
    }

    //2，创建对外的静态方法，判断对对象是否为空，如果为空，调用私有的创建方法
    public static Singleton3 getInstance(){       
        return Singleton3Holder.instance;
    }
    
}