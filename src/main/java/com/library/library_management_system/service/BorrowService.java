package com.library.library_management_system.service;

import org.springframework.stereotype.Service;
import com.library.library_management_system.model.Borrow;
import com.library.library_management_system.repository.BorrowRepository;
import java.util.List;

@Service
public class BorrowService {
    private final BorrowRepository borrowRepository;

    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    public Borrow save(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    public Borrow findById(Long id) {
        return borrowRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        borrowRepository.deleteById(id);
    }
}
