package com.way.jvm.memory;

/**
 * 演示对象因为被GC而调用finalize自我拯救
 * 自我拯救只能拯救一次，系统对一个对象的finalize()方法最多只会调用一次
 * @author reus
 *
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK=null;
    
    public void isAlive(){
        System.out.println("I am still alive");
    }
    
    @Override
    public void finalize() throws Throwable{
        super.finalize();
        System.out.println("Finalize method executes");
        FinalizeEscapeGC.SAVE_HOOK=this;//重新建立引用，逃过一劫
    }
    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK=new FinalizeEscapeGC();
        
        //第一次垃圾回收，可以逃脱
        SAVE_HOOK=null;
        System.gc();
        //Finalizer优先级较低，暂停等待它
        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("No, I am dead :(");
        }
        
        //第二次垃圾回收，逃脱失败
        SAVE_HOOK=null;
        System.gc();
      //Finalizer优先级较低，暂停等待它
        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("No, I am dead :(");
        }
    }

}
