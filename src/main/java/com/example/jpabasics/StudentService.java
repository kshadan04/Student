package com.example.jpabasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student){
        studentRepository.save(student);
        return "student added successfully";
    }

    public String deleteStudent(int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            studentRepository.deleteById(id);
            return "student deleted successfully";
        }
        return "student is not present";
    }

    public Student getStudent(int rollNo) {
        Optional<Student> optionalStudent = studentRepository.findById(rollNo);
        if(optionalStudent.isPresent()){
           return optionalStudent.get();
        }
        return null;
    }
}
