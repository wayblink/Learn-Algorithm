package com.way.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class LearnAnnotation {

    public static void main(String[] args) {
        Class c=null;
        try {
            c=Class.forName("com.way.annotation.F");
            if(c.isAnnotationPresent(Description.class)){
                Description d=(Description)c.getAnnotation(Description.class);
                System.out.println(d.value());
                Method[] ms=c.getMethods();
                for(Method m:ms){
                    if(m.isAnnotationPresent(Description.class)){
                        Description dd=m.getAnnotation(Description.class);
                        System.out.println(dd.value());
                    }
                }
                Field[] fs=c.getFields();
                for(Field f:fs){
                    if(f.isAnnotationPresent(Description.class)){
                        Description ddd=f.getAnnotation(Description.class);
                        System.out.println(ddd.value());
                    }
                }
                      
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Repeatable(Descriptions.class)
@interface Description{
    String value();
    int put() default 1;
}

@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@interface Descriptions{
    Description[] value();
}





