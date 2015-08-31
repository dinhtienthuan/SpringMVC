package com.blogspot.dinhtienthuan.controller;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blogspot.dinhtienthuan.dao.EmployeeDAO;
import com.blogspot.dinhtienthuan.entity.Employee;

@Controller
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    @Qualifier("employeeDAO")
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView findEmployee(ModelAndView modelView) {
        logger.info("Inside findEmployee() method.");
        modelView.setViewName("employee");
        try {
            for (int i = 0; i < 100; i++) {
                Employee employee = employeeDAO.findByEmployeeId(10001);
                modelView.addObject("employee", employee);
                System.out.println("Employee name: " + employee.getFirstName());
            }
        } catch (SQLException e) {
            logger.debug(e.getMessage());
        }

        return modelView;
    }
}
