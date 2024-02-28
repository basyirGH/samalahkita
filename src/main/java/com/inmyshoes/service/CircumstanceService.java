package com.inmyshoes.service;

import com.inmyshoes.model.Circumstance;
import com.inmyshoes.repository.CircumstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CircumstanceService {

    @Autowired
    private CircumstanceRepository circumstanceRepository;

    public Circumstance save(Circumstance circumstance) {
        return circumstanceRepository.save(circumstance);
    }

    public Circumstance getById(long circumstanceId) {
        return circumstanceRepository.findById(circumstanceId).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public List<Circumstance> getAll() {
        return circumstanceRepository.findAll();
    }

    public Circumstance update(long circumstanceId, Circumstance circumstance) {
        Circumstance existingCircumstance = circumstanceRepository.findById(circumstanceId).orElseThrow(() -> new RuntimeException("Not Found"));
        existingCircumstance.setName(circumstance.getName());
        circumstanceRepository.save(existingCircumstance);
        return existingCircumstance;
    }

    public Circumstance delete(long circumstanceId) {
        Circumstance existingCircumstance = circumstanceRepository.findById(circumstanceId).orElseThrow(() -> new RuntimeException("Not Found"));
        circumstanceRepository.deleteById(circumstanceId);
        return existingCircumstance;
    }

    public Circumstance getByName(String name) {
        return circumstanceRepository.getCircumstanceByName(name);
    }

    public List<Circumstance> getCircumstancesIgnoreCaseLike(String searchString) {
        return circumstanceRepository.findByNameIgnoreCaseLike("%" + searchString + "%");
    }

    
}