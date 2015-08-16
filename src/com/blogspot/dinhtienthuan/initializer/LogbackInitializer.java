package com.blogspot.dinhtienthuan.initializer;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

public class LogbackInitializer extends LoggerInitializer {
    private static final String PATH_TO_LOGS_FOLDER_KEY = "path";

    @Override
    public void init() throws ServletException {
        String logbackConfigLocation = servletContext.getInitParameter(LOGGER_CONFIG_LOCATION);
        try {
            JoranConfigurator jc = new JoranConfigurator();

            LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
            jc.setContext(loggerContext);
            loggerContext.reset();

            String pathToLogFolder = servletContext.getRealPath(DEFAULT_LOGS_FOLDER);
            loggerContext.putProperty(PATH_TO_LOGS_FOLDER_KEY, pathToLogFolder);

            URL logback = servletContext.getResource(logbackConfigLocation);
            jc.doConfigure(logback);
        } catch (MalformedURLException e) {
            throw new ServletException(e.getMessage());
        } catch (JoranException e) {
            throw new ServletException(e.getMessage());
        }
    }

}
