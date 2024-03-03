package com.inmyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inmyshoes.model.Circumstance;
import com.inmyshoes.model.StoryCard;
import com.inmyshoes.model.Subject;

import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {


}