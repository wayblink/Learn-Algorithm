package com.way.jvm.memory;

/*
 * JVM Stack StackOverFlow
 * VMargs:GC -Xss128k
 */
public class JVMStackSOF {
    private int stackLength=1;
    
    public void stackLeak(){
        stackLength++;
        stackLeak();    
    }
    public static void main(String[] args) throws Throwable {
        JVMStackSOF oom=new JVMStackSOF();
        try{
            oom.stackLeak();
        }catch (Throwable e) {
            System.out.println("Stack length: "+oom.stackLength);
            e.printStackTrace();
            throw e;
        }
        
    }

}
