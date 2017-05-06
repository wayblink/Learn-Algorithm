package com.way.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeToFlatFile {

    public static void main(String[] args) throws Exception {
        
        SerializeToFlatFile ser=new SerializeToFlatFile();
        ser.savePerson();
        ser.restorePerson();
    }
    
    public void savePerson() throws Exception{
        Person myPerson=new Person("Jay",24);
        
        FileOutputStream fos=new FileOutputStream("d:\\person.txt");
        
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        
        System.out.println("Person--Jay,24---written");
        
        oos.writeObject(myPerson);
        oos.flush();
        oos.close();
    }
    
    public void restorePerson() throws Exception{
        FileInputStream fis=new FileInputStream("d:\\person.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        
        Person myPerson=(Person)ois.readObject();
        
        System.out.println(myPerson.name);
        System.out.println(myPerson.age);
    }

}

class Person implements Serializable{
    String name;
    int age;
    public Person(){}
    
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
}
