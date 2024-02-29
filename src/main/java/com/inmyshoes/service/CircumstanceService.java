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
        return circumstanceRepository.findByName(name);
    }

    public List<Circumstance> getByLevel(String level) {
        return circumstanceRepository.findByLevel(level);
    }

    /*
     * INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (1, 'My cat just passed away', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (2, 'My coworkers are probably talking about me in a language I don\'t understand', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (3, 'I am financially unstable but I have no motivation to work', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (4, 'I am the only male sibling out of many sisters', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (5, 'I came from a broken home', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (6, 'I just got rejected in an interview', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (7, 'I feel neglected by my partner', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (8, 'I am falling for someone I cannot possibly be together with', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (9, 'I think I am oversensitive', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (10, 'My favourite artist has a different political stance than mine', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (11, 'I feel depressed but my medical examiner disagrees', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (12, 'I feel like I\'m always surrounded by stupid people but that can\'t be', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (13, 'I have imposter syndrome', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (14, 'I don\'t know if I am introverted or I just lack confidence', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (15, 'I\'m addicted to smoking', '2');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (16, 'I am a male', '1');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (17, 'I am a female', '1');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (18, 'I am a teenager', '1');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (19, 'I am a man', '1');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (20, 'I am a woman', '1');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (21, 'I am Asian', '1');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (22, 'I am Malaysian', '1');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (23, 'I am American', '1');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (24, 'I am Mexican', '1');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (25, 'I am wealthy', '1');
INSERT INTO `circumstance` (`id`, `name`, `level`) VALUES (26, 'I am broke', '1');

     */

    
}
