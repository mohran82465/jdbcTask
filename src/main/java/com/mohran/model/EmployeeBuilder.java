package com.mohran.model;

public class EmployeeBuilder {
    private int id ;
    private String name ;
    private String phoneNumber;

    public EmployeeBuilder id(int id)
    {
        this.id= id ;
        return  this ;
    }
    public EmployeeBuilder name(String name)
    {
        this.name = name ;
        return  this ;
    }
    public EmployeeBuilder phoneNumber(String phoneNumber)
    {
        this.phoneNumber= phoneNumber ;
        return  this ;
    }
    public Employee build()
    {
        return new Employee(id,name,phoneNumber);
    }
}
