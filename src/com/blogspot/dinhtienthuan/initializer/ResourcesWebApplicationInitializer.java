package com.blogspot.dinhtienthuan.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

public class ResourcesWebApplicationInitializer implements WebApplicationInitializer {
    private LoggerInitializer loggerInitializer;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        initLoggerConfiguration(servletContext);
    }

    private void initLoggerConfiguration(ServletContext servletContext) throws ServletException {
        LoggerInitializerFactory loggerInitializerFactory = new LoggerInitializerFactory(servletContext);
        loggerInitializer = loggerInitializerFactory.loadLoggerInitializer();
        loggerInitializer.init();
    }

}
