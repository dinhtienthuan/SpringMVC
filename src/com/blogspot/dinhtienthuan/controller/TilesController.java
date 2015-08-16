package com.blogspot.dinhtienthuan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TilesController {
    private static final Logger logger = LoggerFactory.getLogger(TilesController.class);

    @RequestMapping(value = "/tiles", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelView) {
        logger.info("Inside index()");
        modelView.addObject("message", "This is an example of Spring integrated with Tiles 3.");
        modelView.setViewName("tiles");
        return modelView;
    }
}
