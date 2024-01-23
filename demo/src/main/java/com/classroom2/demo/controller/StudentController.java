package com.classroom2.demo.controller;

import com.classroom2.demo.models.Response;
import com.classroom2.demo.models.Student;
import com.classroom2.demo.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.List;
//import java.util.logging.Logger;



@RestController
@RequestMapping("/student")
public class StudentController {

//    Logger logger = (Logger) LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private IStudentService service;

    @PostMapping("/addStudent")
    public ResponseEntity<Response> createStudent(@Valid @RequestBody  Student student){
//        logger.info("Creating students registration");

        Response response = service.createStudent(student);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @GetMapping("/studentById/{id}")
    public ResponseEntity<Student> getUsersById(@PathVariable(value = "id") String id){
//        logger.info("Getting students by ID");

        Student student = service.getStudent(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id")String id,@RequestBody Student student){
//        logger.info("Updating student ");

        Student s = service.updateStudent(id,student);
        return new ResponseEntity<Student>(s,HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") String id, @RequestBody Student student){
//        logger.info("Deleting student");
        Student s = service.deleteStudent(id);
        return  new ResponseEntity<Student>(s,HttpStatus.OK);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
//        logger.info("Getting all students");

        List<Student> students = service.getAll();
        return students ;
    }
}
