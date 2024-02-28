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

   //get a single circumstance by its id
    @GetMapping("/circumstance")
    public ResponseEntity<Circumstance> getCircumstance(@RequestParam(name = "circumstanceId") long circumstanceId) {
        Circumstance circumstance = circumstanceService.getById(circumstanceId);
        return new ResponseEntity<>(circumstance, HttpStatus.OK);
    }

    //get all the circumstances in the table in our database
    @GetMapping("/circumstances")
    public List<Circumstance> getCircumstance() {
        return circumstanceService.getAll();
    }

    //update an existing circumstance in the database
    @PatchMapping("/circumstance")
    public ResponseEntity<Circumstance> updateCircumstance(@RequestParam(name ="circumstanceId") long circumstanceId, @RequestBody Circumstance circumstance) {
        Circumstance updatedCircumstance = circumstanceService.update(circumstanceId, circumstance);
        return new ResponseEntity<>(updatedCircumstance, HttpStatus.OK);
    }

    // delete an existing circumstance in the database
    @DeleteMapping("/circumstance")
    public ResponseEntity<Circumstance> deleteCircumstance(@RequestParam(name ="circumstanceId") long circumstanceId) {
        Circumstance deletedCircumstance = circumstanceService.delete(circumstanceId);
        return new ResponseEntity<>(deletedCircumstance, HttpStatus.OK);
    }

    // get circumstance by name using a raw SQL statement
    @GetMapping("/circumstance-by-name")
    public Circumstance getCircumstanceByName(@RequestParam(name ="circumstanceName") String circumstanceName) {
        return circumstanceService.getByName(circumstanceName);
    }

    // get search results by name
    @GetMapping("/circumstance-by-name-like")
    public List<Circumstance> getCircumstanceByNameLike(@RequestParam(name ="search") String search) {
        return circumstanceService.getCircumstancesIgnoreCaseLike(search);
    }

}