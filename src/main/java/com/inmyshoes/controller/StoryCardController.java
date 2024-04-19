package com.inmyshoes.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inmyshoes.model.Circumstance;
import com.inmyshoes.model.StoryCard;
import com.inmyshoes.service.CircumstanceService;
import com.inmyshoes.service.StoryCardService;

@RestController
public class StoryCardController {

    @Autowired
    private StoryCardService storyCardService;

    @Autowired
    private CircumstanceService circumstanceService;

    @GetMapping("/story-card-builder-view-1")
    public ModelAndView getStoryBuilderView1(@RequestParam(name = "circumstanceId") String circumstanceId,
            @RequestParam(name = "circumstanceName") String circumstanceName) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("story-builder-1");
        mav.addObject("circumstanceName", circumstanceName);
        mav.addObject("circumstanceId", circumstanceId);

        mav.addObject("emotionCC", circumstanceService.getTop90ByCategory("emotion"));
        mav.addObject("actionCC", circumstanceService.getTop90ByCategory("action"));
        mav.addObject("goalCC", circumstanceService.getTop90ByCategory("goal"));
        mav.addObject("otherCC", circumstanceService.getTop45ByCategory("main"));
        mav.addObject("demographicCC", circumstanceService.getTop90ByCategory("demographic"));
        return mav;
    }

    @GetMapping("/story-card-builder-view-2")
    public ModelAndView getStoryBuilderView2() {
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("story-builder-2");
        return mav;
    }

    @PostMapping("/story-card-submit")
    public ResponseEntity<Map<String, String>> doSubmitStoryCard(@RequestBody Map<String, Map<String, String>> circumstances) {
        String result = "";

        StoryCard emptySc = new StoryCard();
        StoryCard scWithId = storyCardService.save(emptySc);
        long scId = scWithId.getId();

        ArrayList<Circumstance> ccList = new ArrayList<Circumstance>();

        circumstances.forEach((key, value) -> {
            Circumstance cc = new Circumstance();
            cc.setId(Long.valueOf(key));
            value.forEach((innerKey, innerValue) -> {
                cc.setName(innerKey);
                cc.setCategory(innerValue);
            });
            ccList.add(cc);
            storyCardService.linkCircumstancesWithStoryCard(cc.getId(), scId);
        });
        //return result;
        // for (Circumstance cc : ccList) {
        //     System.out.println(cc.getId());
        //     System.out.println(cc.getName());
        //     System.out.println(cc.getCategory());
        // }

        // You are assigning an instance of HashMap to this variable. 
        // This is a good practice because it adheres to the principle of coding to 
        // interfaces rather than implementations. It allows you to change the 
        // implementation later (e.g., switch to a different map implementation like 
        // LinkedHashMap or TreeMap) without affecting the rest of the code that relies 
        // on the Map interface.
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "success");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
