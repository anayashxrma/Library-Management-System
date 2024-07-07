package com.library.library_management_system.controller;

import com.library.library_management_system.model.Student;
import com.library.library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.findById(id);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student student = studentService.findById(id);
        if (student != null) {
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            return ResponseEntity.ok(studentService.save(student));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (studentService.findById(id) != null) {
            studentService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
