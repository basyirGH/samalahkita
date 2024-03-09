package com.inmyshoes.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inmyshoes.model.Circumstance;
import com.inmyshoes.model.StoryCard;
import com.inmyshoes.service.StoryCardService;

@RestController
public class StoryCardController {

    @Autowired
    private StoryCardService storyCardService;

    @GetMapping("/story-card-builder-view-1")
    public ModelAndView getStoryBuilderView1(@RequestParam(name = "circumstanceId") String circumstanceId,
            @RequestParam(name = "circumstanceName") String circumstanceName) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("story-builder-1");
        mav.addObject("circumstanceName", circumstanceName);
        mav.addObject("circumstanceId", circumstanceId);
        return mav;
    }

    @GetMapping("/story-card-builder-view-2")
    public ModelAndView getStoryBuilderView2() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("story-builder-2");
        // mav.addObject("circumstanceId", circumstanceId);
        return mav;
    }

    // @PostMapping("/story-card-submit")
    // public void doSubmitStoryCard(@RequestBody Map<String, Map<String, String>> circumstances) {
    //     String result = "";

    //     StoryCard emptySc = new StoryCard();
    //     StoryCard scWithId = storyCardService.save(emptySc);
    //     long scId = scWithId.getId();

    //     ArrayList<Circumstance> ccList = new ArrayList<Circumstance>();

    //     circumstances.forEach((key, value) -> {
    //         Circumstance cc = new Circumstance();
    //         cc.setId(Long.valueOf(key));
    //         value.forEach((innerKey, innerValue) -> {
    //             cc.setName(innerKey);
    //             cc.setCategory(innerValue);
    //         });
    //         storyCardService.linkCircumstancesWithStoryCard(cc.getId(), scId);
    //     });
    //     //return result;
    // }

}
