package com.devryan.studentsystem.service;

import com.devryan.studentsystem.model.Student;
import com.devryan.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }


    public Student updateStudent(Long id, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();

            existingStudent.setName(student.getName());
            existingStudent.setAddress(student.getAddress());

            return studentRepository.save(existingStudent);
        }
        return null;
    }

}
