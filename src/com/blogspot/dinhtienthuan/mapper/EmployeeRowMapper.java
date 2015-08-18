package com.blogspot.dinhtienthuan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.blogspot.dinhtienthuan.entity.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeRowMapper.class);

    @Override
    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        logger.info("Mapping row {}", rowNum);
        Employee employee = new Employee();
        employee = new Employee();
        employee.setId(resultSet.getDouble("emp_no"));
        employee.setBirthDate(resultSet.getDate("birth_date"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setGender(resultSet.getString("gender"));
        employee.setHireDate(resultSet.getDate("hire_date"));
        return employee;
    }

}
