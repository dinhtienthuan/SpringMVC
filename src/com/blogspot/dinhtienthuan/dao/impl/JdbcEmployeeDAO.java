package com.blogspot.dinhtienthuan.dao.impl;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.blogspot.dinhtienthuan.dao.EmployeeDAO;
import com.blogspot.dinhtienthuan.entity.Employee;
import com.blogspot.dinhtienthuan.mapper.EmployeeRowMapper;

@Repository("employeeDAO")
public class JdbcEmployeeDAO implements EmployeeDAO {
    private static final Logger logger = LoggerFactory.getLogger(JdbcEmployeeDAO.class);

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Override
    public Employee findByEmployeeId(double employeeId) throws SQLException {
        String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE emp_no = ?";
        logger.info("Find employee by id = {}", employeeId);
        jdbcTemplate = new JdbcTemplate(dataSource);
        // Employee employee = jdbcTemplate.queryForObject(sql, new Object[]
        // {employeeId}, new EmployeeRowMapper());
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, new Object[] {employeeId});
        Employee employee = new Employee();
        rowSet.next();
        employee.setId(rowSet.getInt("emp_no"));
        employee.setBirthDate(rowSet.getDate("birth_date"));
        employee.setFirstName(rowSet.getString("first_name"));
        employee.setLastName(rowSet.getString("last_name"));
        employee.setGender(rowSet.getString("gender"));
        employee.setHireDate(rowSet.getDate("hire_date"));

        return employee;
    }
}
