package com.library.library_management_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.library.library_management_system.model.Borrow;
import com.library.library_management_system.service.BorrowService;
import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {
    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping
    public List<Borrow> getAllBorrows() {
        return borrowService.findAll();
    }

    @PostMapping
    public Borrow createBorrow(@RequestBody Borrow borrow) {
        return borrowService.save(borrow);
    }

    @PutMapping("/return/{id}")
    public ResponseEntity<Borrow> returnBook(@PathVariable Long id) {
        Borrow borrow = borrowService.findById(id);
        if (borrow != null) {
            borrow.setReturned(true);
            return ResponseEntity.ok(borrowService.save(borrow));
        }
        return ResponseEntity.notFound().build();
    }
}
