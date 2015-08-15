package com.blogspot.dinhtienthuan.initializer;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public abstract class LoggerInitializer {
    protected static final String LOGGER_CONFIG_LOCATION = "loggerConfigLocation";
    protected static final String DEFAULT_LOGS_FOLDER = File.separator + "logs";

    protected ServletContext servletContext;

    public abstract void init() throws ServletException;

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
