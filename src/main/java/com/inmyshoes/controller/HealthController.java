package com.inmyshoes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HealthController {
    
    @GetMapping("/")
    public ModelAndView ping() {
      
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;

    }
}
