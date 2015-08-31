package com.blogspot.dinhtienthuan.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blogspot.dinhtienthuan.dao.EmployeeDAO;
import com.blogspot.dinhtienthuan.entity.Employee;

@Repository("hibernateEmployeeDAO")
public class HibernateEmployeeDAO implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public HibernateEmployeeDAO() {}

    @Override
    @Transactional
    public Employee findByEmployeeId(double employeeId) throws SQLException {
        String queryString = "FROM Employee WHERE emp_no = " + employeeId;
        Query query = sessionFactory.getCurrentSession().createQuery(queryString);
        @SuppressWarnings("unchecked")
        List<Employee> employees = query.list();

        if (employees != null && !employees.isEmpty()) {
            return employees.get(0);
        }
        return null;
    }

}
