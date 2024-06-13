package com.devryan.studentsystem.service;

import com.devryan.studentsystem.model.Student;

import java.util.List;

public interface StudentService {

    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}
