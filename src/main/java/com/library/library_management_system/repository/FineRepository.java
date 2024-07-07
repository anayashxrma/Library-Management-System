package com.library.library_management_system.repository;

import com.library.library_management_system.model.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepository extends JpaRepository<Fine, Long> {
}
