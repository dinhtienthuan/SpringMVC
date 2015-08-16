package com.blogspot.dinhtienthuan.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class LoggerInitializerFactory {
    private static final String LOGGER_INITIALIZER_CLASS = "loggerInitializerClass";

    private ClassLoader classLoader;
    private ServletContext servletContext;

    public LoggerInitializerFactory(ServletContext servletContext) {
        classLoader = getClass().getClassLoader();
        this.servletContext = servletContext;
    }

    public LoggerInitializer loadLoggerInitializer() throws ServletException {
        LoggerInitializer loggerInitializer = null;
        try {
            String loggerInitializerClass = servletContext.getInitParameter(LOGGER_INITIALIZER_CLASS);
            Class<?> loadedClass = classLoader.loadClass(loggerInitializerClass);
            if (LoggerInitializer.class.getName().equals(loadedClass.getSuperclass().getName())) {
                loggerInitializer = (LoggerInitializer) loadedClass.newInstance();
                loggerInitializer.setServletContext(servletContext);
            }
        } catch (ClassNotFoundException e) {
            throw new ServletException(e.getMessage());
        } catch (InstantiationException e) {
            throw new ServletException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new ServletException(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new ServletException(e.getMessage());
        } catch (SecurityException e) {
            throw new ServletException(e.getMessage());
        }
        return loggerInitializer;
    }
}
