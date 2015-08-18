package com.blogspot.dinhtienthuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.blogspot.dinhtienthuan.dao.EmployeeDAO;
import com.blogspot.dinhtienthuan.entity.Employee;

@Repository("employeeDAO")
public class JdbcEmployeeDAO implements EmployeeDAO {
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Override
    public Employee findByEmployeeId(double employeeId) throws SQLException {
        String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE emp_no = ?";
        Connection connection = null;
        Employee employee = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, employeeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getDouble("emp_no"));
                employee.setBirthDate(rs.getDate("birth_date"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setGender(rs.getString("gender"));
                employee.setHireDate(rs.getDate("hire_date"));
            }
            rs.close();
            ps.close();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return employee;
    }

}
