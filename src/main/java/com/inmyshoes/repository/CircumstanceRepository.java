package com.inmyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inmyshoes.model.Circumstance;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CircumstanceRepository extends JpaRepository<Circumstance, Long> {

    @Query(value = "SELECT * FROM circumstance WHERE name = ?1", nativeQuery = true)
    Circumstance getCircumstanceByName(String circumstanceName);

    List<Circumstance> findByNameIgnoreCaseLike(String searchString);

}