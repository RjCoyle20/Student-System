package com.devryan.studentsystem.controller;

import com.devryan.studentsystem.model.Student;
import com.devryan.studentsystem.repository.StudentRepository;
import com.devryan.studentsystem.service.StudentService;
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

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student student) {

        Optional<Student> updateStudent = studentService.findStudentById(id);

        if(updateStudent.isPresent()) {
            updateStudent.get().setName(student.getName());
            updateStudent.get().setAddress(student.getAddress());
            studentService.saveStudent(student);
        }
        return new ResponseEntity<>(studentService.findStudentById(id), HttpStatus.OK);
    }
}
