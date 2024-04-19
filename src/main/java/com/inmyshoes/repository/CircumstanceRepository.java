package com.inmyshoes.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.inmyshoes.model.Circumstance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CircumstanceRepository extends JpaRepository<Circumstance, Long> {

    Circumstance findByName(String circumstanceName);   

    List<Circumstance> findByLevel(String level);

    List<Circumstance> findByCategory(String category);

    List<Circumstance> findTop90ByCategory(String category);

    List<Circumstance> findTop45ByCategory(String category);

    List<Circumstance> findByNameContainingIgnoreCaseAndCategoryEquals(String searchTerm, String category);
}