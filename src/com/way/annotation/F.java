package com.way.annotation;

@Description("I am class description1")
@Description("I am class description2")
class F{
    
    @Description("I am method description")
    public String getName(){
        return null;
    }
    
    @Description("I am field description")
    public String name;
    @Description("I am field description")
    public int id;
    public int age;
}
