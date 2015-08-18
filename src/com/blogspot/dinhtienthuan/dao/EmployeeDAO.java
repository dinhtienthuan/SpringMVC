package com.blogspot.dinhtienthuan.dao;

import java.sql.SQLException;

import com.blogspot.dinhtienthuan.entity.Employee;

public interface EmployeeDAO {
    public Employee findByEmployeeId(double employeeId) throws SQLException;
}
