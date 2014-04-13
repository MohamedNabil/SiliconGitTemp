package com.siliconnile.web.controller;

import com.siliconnile.domain.SampleObject;
import com.siliconnile.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: Andrew
 * Date: 6/20/13
 */
@Controller("/")
public class TestController {
    
    @Autowired
    private TestService testService;

    @RequestMapping(method = RequestMethod.GET)
    public String init() {
        return "example";
    }
}
