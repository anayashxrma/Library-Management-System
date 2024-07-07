package com.library.library_management_system.controller;

import com.library.library_management_system.model.Fine;
import com.library.library_management_system.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/fines")
public class FineController {

    @Autowired
    private FineService fineService;

    @GetMapping
    public List<Fine> getAllFines() {
        return fineService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fine> getFineById(@PathVariable Long id) {
        Fine fine = fineService.findById(id);
        return fine != null ? ResponseEntity.ok(fine) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Fine createFine(@RequestBody Fine fine) {
        return fineService.save(fine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fine> updateFine(@PathVariable Long id, @RequestBody Fine fineDetails) {
        Fine fine = fineService.findById(id);
        if (fine != null) {
            fine.setRatePerDay(fineDetails.getRatePerDay());
            return ResponseEntity.ok(fineService.save(fine));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFine(@PathVariable Long id) {
        if (fineService.findById(id) != null) {
            fineService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/calculate/{borrowedId}")
    public ResponseEntity<BigDecimal> calculateFine(@PathVariable Long borrowedId) {
        BigDecimal fineAmount = fineService.calculateFine(borrowedId);
        return ResponseEntity.ok(fineAmount);
    }
}
