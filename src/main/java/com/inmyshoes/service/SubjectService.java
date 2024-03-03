package com.inmyshoes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inmyshoes.model.StoryCard;
import com.inmyshoes.model.Subject;
import com.inmyshoes.repository.StoryCardRepository;
import com.inmyshoes.repository.SubjectRepository;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }
}
