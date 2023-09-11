package com.codingdojo.SaveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.SaveTravels.Model.Save;
import com.codingdojo.SaveTravels.repositories.Travel_Repository;

@Service
public class SaveService {
    private final Travel_Repository travelRepository;
    
    public SaveService(Travel_Repository travelRepository) {
        this.travelRepository = travelRepository;
    }
    
    public List<Save> getAllSaves() {
        return travelRepository.findAll();
    }
    
    public Save createSave(Save save) {
        return travelRepository.save(save);
    }
    
    public Save getSaveById(Long id) {
        Optional<Save> optionalSave = travelRepository.findById(id);
        if (optionalSave.isPresent()) {
            return optionalSave.get();
        } else {
            return null;
        }
    }
    
    public Save updateSave(Long id, Save updatedSave) {
        Optional<Save> optionalSave = travelRepository.findById(id);
        if (optionalSave.isPresent()) {
            Save save = optionalSave.get();
            save.setExpense(updatedSave.getExpense());
            save.setAuthor(updatedSave.getAuthor());
            save.setVendor(updatedSave.getVendor());
            save.setAmount(updatedSave.getAmount());
            // Update other fields as needed
            
            return travelRepository.save(save);
        } else {
            return null;
        }
    }
    
    public void deleteSave(Long id) {
        travelRepository.deleteById(id);
    }
}
