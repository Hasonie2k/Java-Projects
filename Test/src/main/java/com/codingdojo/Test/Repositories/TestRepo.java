package com.codingdojo.Test.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Test.Models.TestModel;

@Repository
public interface TestRepo extends CrudRepository<TestModel, Long> {
    List<TestModel> findAll();
}
