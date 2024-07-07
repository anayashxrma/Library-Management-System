package com.library.library_management_system.service;

import com.library.library_management_system.model.Student;
import com.library.library_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
