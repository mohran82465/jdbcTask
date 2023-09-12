package com.mohran.service;

import com.mohran.model.Employee;

import java.util.*;

public interface EmployeeService {
    public List<Employee> findAll() ;
    public void add(Employee employee);
    public void  update (Employee employee);
    public  void  delete (int id) ;
    public Employee search (int id);
}
