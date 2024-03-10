package com.inmyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inmyshoes.model.Circumstance;
import com.inmyshoes.service.CircumstanceService;

@RestController
public class HealthController {
    
    @Autowired
    CircumstanceService circumstanceService;

    @GetMapping("/")
    public ModelAndView ping() {
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        List<Circumstance> ccList = circumstanceService.getByLevel("2");
        mav.addObject("ccList", ccList);
        return mav;

    }
}
