package com.codingdojo.dojos_ninjas.services;

import com.codingdojo.dojos_ninjas.models.Dojo;
import com.codingdojo.dojos_ninjas.repositories.DojoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {

    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> getAllDojos() {
        return dojoRepository.findAll();
    }

    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }

    public Dojo getDojoById(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        return optionalDojo.orElse(null);
    }

}
