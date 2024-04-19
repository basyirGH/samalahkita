package com.inmyshoes.service;

import com.inmyshoes.model.Circumstance;
import com.inmyshoes.repository.CircumstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
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
        return circumstanceRepository.findByName(name);
    }

    public List<Circumstance> getByLevel(String level) {
        return circumstanceRepository.findByLevel(level);
    }

    public List<Circumstance> getByCategory(String category) {
        return circumstanceRepository.findByCategory(category);
    }

    public List<Circumstance> getTop90ByCategory(String category) {
        return circumstanceRepository.findTop90ByCategory(category);
    }

    public List<Circumstance> getTop45ByCategory(String category) {
        return circumstanceRepository.findTop45ByCategory(category);
    }

    public List<Circumstance> getBySearchTerm(String searchTerm, String category) {
        return circumstanceRepository.findByNameContainingIgnoreCaseAndCategoryEquals(searchTerm, category);
    }





    
}
