package com.inmyshoes.controller;

import com.inmyshoes.model.Circumstance;
import com.inmyshoes.service.CircumstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CircumstanceController {

    @Autowired
    private CircumstanceService circumstanceService;

    // insert a circumstance into database
    @PostMapping("/circumstance")
    public ResponseEntity<Circumstance> saveCircumstance(@RequestBody Circumstance circumstance) {
        Circumstance savedCircumstance = circumstanceService.save(circumstance);
        return new ResponseEntity<>(savedCircumstance, HttpStatus.CREATED);
    }

    // get a single circumstance by its id
    @GetMapping("/circumstance")
    public ResponseEntity<Circumstance> getCircumstance(@RequestParam(name = "circumstanceId") long circumstanceId) {
        Circumstance circumstance = circumstanceService.getById(circumstanceId);
        return new ResponseEntity<>(circumstance, HttpStatus.OK);
    }

    // get all the circumstances in the table in our database
    @GetMapping("/circumstances")
    public List<Circumstance> getCircumstances() {
        return circumstanceService.getAll();
    }

    // update an existing circumstance in the database
    @PatchMapping("/circumstance")
    public ResponseEntity<Circumstance> updateCircumstance(@RequestParam(name = "circumstanceId") long circumstanceId,
            @RequestBody Circumstance circumstance) {
        Circumstance updatedCircumstance = circumstanceService.update(circumstanceId, circumstance);
        return new ResponseEntity<>(updatedCircumstance, HttpStatus.OK);
    }

    // delete an existing circumstance in the database
    @DeleteMapping("/circumstance")
    public ResponseEntity<Circumstance> deleteCircumstance(@RequestParam(name = "circumstanceId") long circumstanceId) {
        Circumstance deletedCircumstance = circumstanceService.delete(circumstanceId);
        return new ResponseEntity<>(deletedCircumstance, HttpStatus.OK);
    }

    // get cc in specific level
    @GetMapping("/circumstance-level")
    public List<Circumstance> getCircumstancesByLevel(@RequestParam(name = "level") String level) {
        return circumstanceService.getByLevel(level);
    }

    // get cc in specific category
    @GetMapping("/circumstance-category")
    public List<Circumstance> getCircumstancesByCategory(@RequestParam(name = "category") String category) {
        return circumstanceService.getByCategory(category);
    }

    // get cc in specific main search terms
    @GetMapping("/circumstance-search-main")
    public List<Circumstance> getSearchResultForMain(@RequestParam(name = "mainSearchTerm") String mainSearchTerm) {
        return circumstanceService.getBySearchTerm(mainSearchTerm, "main");
    }

    @GetMapping("/circumstance-search-emotion")
    public List<Circumstance> getSearchResultForEmotion(
            @RequestParam(name = "emotionSearchTerm") String emotionSearchTerm) {
        return circumstanceService.getBySearchTerm(emotionSearchTerm, "emotion");
    }

    @GetMapping("/circumstance-search-action")
    public List<Circumstance> getSearchResultForAction(
            @RequestParam(name = "actionSearchTerm") String actionSearchTerm) {
        return circumstanceService.getBySearchTerm(actionSearchTerm, "action");
    }

    @GetMapping("/circumstance-search-goal")
    public List<Circumstance> getSearchResultForGoal(@RequestParam(name = "goalSearchTerm") String goalSearchTerm) {
        return circumstanceService.getBySearchTerm(goalSearchTerm, "goal");
    }

    @GetMapping("/circumstance-search-demography")
    public List<Circumstance> getSearchResultForDemography(
            @RequestParam(name = "demographySearchTerm") String demographySearchTerm) {
        return circumstanceService.getBySearchTerm(demographySearchTerm, "demographic");
    }

}