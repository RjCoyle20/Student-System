package com.devryan.studentsystem.service;

import com.devryan.studentsystem.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Optional<Student> findStudentById(int id);
}
