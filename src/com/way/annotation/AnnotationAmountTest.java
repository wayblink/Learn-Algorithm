package com.way.annotation;

import java.lang.annotation.Annotation;

public class AnnotationAmountTest {

    public static void main(String[] args){
        Class c=null;
        try {
            c=Class.forName("com.way.annotation.F");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Annotation a=c.getAnnotation(Description.class);
        Annotation[] aa=c.getAnnotations();
        Annotation[] d=c.getAnnotationsByType(Description.class);
        System.out.println(aa.length);
        System.out.println(d.length);
    }
}
