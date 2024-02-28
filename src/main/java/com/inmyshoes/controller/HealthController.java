package com.inmyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.inmyshoes.service.CircumstanceService;

@RestController
public class HealthController {
    
    @Autowired
    CircumstanceService circumstanceService;

    @GetMapping("/")
    public ModelAndView ping() {
      
        ModelAndView mav = new ModelAndView();
        mav.addObject("circumstances", circumstanceService.getAll());
        mav.setViewName("index");
        return mav;

    }
}
