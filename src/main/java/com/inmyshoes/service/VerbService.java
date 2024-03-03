package com.inmyshoes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inmyshoes.model.StoryCard;
import com.inmyshoes.model.Subject;
import com.inmyshoes.model.Verb;
import com.inmyshoes.repository.StoryCardRepository;
import com.inmyshoes.repository.SubjectRepository;
import com.inmyshoes.repository.VerbRepository;

@Service
public class VerbService {

    @Autowired
    private VerbRepository verbRepository;

    public List<Verb> getAll() {
        return verbRepository.findAll();
    }
}
