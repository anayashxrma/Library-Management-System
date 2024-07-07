package com.library.library_management_system.service;

import com.library.library_management_system.model.Fine;
import com.library.library_management_system.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FineService {

    @Autowired
    private FineRepository fineRepository;

    public List<Fine> findAll() {
        return fineRepository.findAll();
    }

    public Fine findById(Long id) {
        return fineRepository.findById(id).orElse(null);
    }

    public Fine save(Fine fine) {
        return fineRepository.save(fine);
    }

    public void deleteById(Long id) {
        fineRepository.deleteById(id);
    }

    public BigDecimal calculateFine(Long borrowedId) {
        // Implement the logic to calculate the fine
        return BigDecimal.ZERO; // Placeholder
    }
}
