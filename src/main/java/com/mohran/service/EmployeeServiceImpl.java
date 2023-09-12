package com.mohran.service;

import com.mohran.dao.DBConnection;
import com.mohran.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    @Override
    public List<Employee> findAll() {
        Connection connection = DBConnection.getConnection();
        if(connection == null )
        {
            System.out.println("Error in database connection");
            return null;
        }
        String query = "SELECT * FROM employee";
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Employee employee = Employee.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .phoneNumber(resultSet.getString("phoneNumber"))
                        .build();
                employees.add(employee);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    @Override
    public void add(Employee employee) {
        Connection connection = DBConnection.getConnection();
        if(connection==null)
        {
            System.out.println("Error in database connection");
            return;
        }
        String query = "INSERT INTO employee (name,phoneNumber) VALUES (?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2, employee.getPhoneNumber());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void update(Employee employee) {
        Connection connection = DBConnection.getConnection();
        if(connection==null)
        {
            System.out.println("Error in database connection");
            return;
        }
        String query = "UPDATE employee SET name = ? , phoneNumber=? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getPhoneNumber());
            preparedStatement.setInt(3,employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        if(connection== null)
        {
            System.out.println("Error in database connection");
            return;
        }
        String query = "DELETE FROM employee WHERE id=?";
        try (PreparedStatement preparedStatement= connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Employee search(int id) {
        Connection connection = DBConnection.getConnection();
        if(connection==null)
        {
            System.out.println("Error in database connection");
            return null;
        }
        String query = "SELECT * FROM employee WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet .next())
            {
                Employee employee = Employee.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .phoneNumber(resultSet.getString("phoneNumber"))
                        .build();
                return employee;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
