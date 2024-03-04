package com.inmyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.inmyshoes.service.StoryCardService;

@RestController
public class StoryCardController {

    @Autowired
    private StoryCardService storyCardService;

    @GetMapping("/story-card-builder-view-1")
    public ModelAndView getStoryBuilderView1(@RequestParam(name = "circumstanceId") String circumstanceId,
            @RequestParam(name = "circumstanceName") String circumstanceName) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("story-builder-2");
        mav.addObject("circumstanceName", circumstanceName);
        mav.addObject("circumstanceId", circumstanceId);
        return mav;
    }

    @GetMapping("/story-card-builder-view-2")
    public ModelAndView getStoryBuilderView2(@RequestParam(name = "circumstanceId") String circumstanceId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("story-builder-2");
        mav.addObject("circumstanceId", circumstanceId);
        return mav;
    }

}
