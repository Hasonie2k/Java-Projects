package com.codingdojo.dojos_ninjas.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojos_ninjas.models.Ninja;

import java.util.List;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
    List<Ninja> findAll();
    List<Ninja> findByDojoId(Long dojos_Id);
}