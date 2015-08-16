package com.blogspot.dinhtienthuan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/logback", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelView) {
        logger.info("index() is executed.");
        modelView.addObject("message", "Welcome to Logback.");
        modelView.setViewName("logback");
        return modelView;
    }
}
