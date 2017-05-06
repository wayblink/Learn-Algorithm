package com.way.IO.file;

import java.io.File;
import java.io.IOException;

public class FileClassTest1 {

    public static void main(String[] args) throws InterruptedException{
        File src=new File("C:/","test");
        src=new File("C:\\","test");
        System.out.println(src.exists());
        src.mkdirs();
        System.out.println(src.exists());
        System.out.println(src.getPath());
        System.out.println(src.getAbsolutePath());
        System.out.println(src.getParent());
        
        File temp=null;
        try {
            temp=File.createTempFile("test", ".temp");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(temp.exists());
        
        Thread.sleep(5000);
    }
    
    public void test1create(){
        
    }
    
    public void test2refer(){
        
    }
    
    public void test3rw(){
        
    }
    
    public void test4delete(){
        
    }
}
