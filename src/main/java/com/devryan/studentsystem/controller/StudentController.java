package com.devryan.studentsystem.controller;

import com.devryan.studentsystem.model.Student;
import com.devryan.studentsystem.repository.StudentRepository;
import com.devryan.studentsystem.service.StudentService;
import com.devryan.studentsystem.service.StudentServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired StudentServiceImpl studentServiceImpl;

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById (@PathVariable Long id){
        Student student = studentServiceImpl.findStudentById(id);
        if(student == null ) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(student);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {

        Student updateStudent = studentServiceImpl.updateStudent(id, student);
        if (updateStudent == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        try{
            studentServiceImpl.deleteStudent(id);
            return new ResponseEntity<>("Employee with ID " + id + " deleted successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
