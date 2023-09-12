package com.mohran;

import com.mohran.model.Employee;
import com.mohran.service.EmployeeService;
import com.mohran.service.EmployeeServiceImpl;

import java.util.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to employee database store : ");
        while(true)
        {
            System.out.println("What you need from employees : ");
            System.out.println("    1. Show all employees list.");
            System.out.println("    2. Add new employee to the database.");
            System.out.println("    3. Update employee info in database.");
            System.out.println("    4. Delete employee from the database.");
            System.out.println("    5. Find the employee if exist in database.");
            Scanner scanner =new Scanner(System.in);
            int n = scanner.nextInt();

            EmployeeService service = new EmployeeServiceImpl();
            if(n==1)
            {
                System.out.println("The Employees List : ");
                List<Employee> employees;
                employees=service.findAll();
                if(employees.size()==0) System.out.println("the list is empty");
                else
                    for(Employee employee:employees)
                        System.out.println(employee.toString());
                System.out.println("enter any thing to continue...... ");
                String x = scanner.next();
            }
            else if (n==2) {
                Employee employee = new Employee();
                System.out.println("    Enter employee name : ");
                String name = scanner.next();
                System.out.println("    Enter employee phone : ");
                String phone = scanner.next();
//                employee.setId(0);
                employee.setName(name);
                employee.setPhoneNumber(phone);
                service.add(employee);
                System.out.println("    done the employee add to the database.   "   );
                System.out.println("enter any thing to continue...... ");
                String x = scanner.next();
            }
            else if (n==3) {
                Employee employee = new Employee();
                System.out.println("    Enter employee id where you want to update");
                int id = scanner.nextInt();
                System.out.println("    Enter employee new name : ");
                String name = scanner.next();

                System.out.println("    Enter employee new phone : ");
                String phone = scanner.next();
                employee.setId(id);
                employee.setName(name);
                employee.setPhoneNumber(phone);
                service.update(employee);

                System.out.println("    done the employee updated!!!!!");
                System.out.println("enter any thing to continue...... ");
                String x = scanner.next();
            }
            else if (n==4) {
                System.out.println("    Enter employee id where you want to delete");
                int id = scanner.nextInt();
                service.delete(id);
                System.out.println("    done the employee deleted!!!!!");
                System.out.println("enter any thing to continue...... ");
                String x = scanner.next();
            }
            else if (n==5) {
                System.out.println("    Enter employee id where you want to search");
                int id = scanner.nextInt();
                Employee employee = service.search(id);
                if(employee!=null)
                    System.out.println(employee.toString());
                else System.out.println("   employee not founded ...... !!!!!");
                System.out.println("enter any thing to continue...... ");
                String x = scanner.next();
            }
            else {
                System.out.println("    Wrong entry of the order \nplz Enter right number.");

            }


        }
    }
}