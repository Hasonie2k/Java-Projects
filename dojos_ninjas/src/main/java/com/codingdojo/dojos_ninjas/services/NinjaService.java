package com.codingdojo.dojos_ninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojos_ninjas.models.Ninja;
import com.codingdojo.dojos_ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> getAllNinjas() {
        return ninjaRepository.findAll();
    }

    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    public List<Ninja> getNinjasByDojoId(Long dojos_Id) {
        return ninjaRepository.findByDojoId(dojos_Id);
    }
}
