package com.codingdojo.Test.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.Test.Models.TestModel;
import com.codingdojo.Test.Repositories.TestRepo;

@Service
public class TestService {
    private final TestRepo testRepo;

    public TestService(TestRepo testRepo) {
        this.testRepo = testRepo;
    }

    public List<TestModel> getAllTestModels() {
        return testRepo.findAll();
    }

    public void createTestModel(TestModel testModel) {
        testRepo.save(testModel);
    }

    public TestModel getTestModelById(Long id) {
        Optional<TestModel> optionalTestModel = testRepo.findById(id);
        return optionalTestModel.orElse(null);
    }

    public void updateTestModelById(Long id, Integer price, Date updatedAt) {
        TestModel testModel = testRepo.findById(id).orElse(null);
        if (testModel != null) {
            testModel.setPrice(price);
            testModel.setUpdatedAt(updatedAt);
            testRepo.save(testModel);
        }
    }

    public void deleteTestModelById(Long id) {
        testRepo.deleteById(id);
    }



}
