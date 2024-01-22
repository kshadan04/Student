package com.example.jpabasics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
     @Autowired
     StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        String message = studentService.addStudent(student);
        return new ResponseEntity(message, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public  ResponseEntity deleteStudent(@PathVariable("id") int id){
        String response = studentService.deleteStudent(id);
        return new ResponseEntity(response,HttpStatus.CREATED);
    }

    @GetMapping("/get_by_id")
    public ResponseEntity getStudent(@RequestParam("rollNo") int rollNo){
        Student student = studentService.getStudent(rollNo);
        if(student == null){
            return new ResponseEntity<>("roll No not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(student,HttpStatus.CREATED);
    }
}
