package com.classroom2.demo.service;

import com.classroom2.demo.models.Response;
import com.classroom2.demo.models.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentService {
    List<Student> getStudentList();
    Response createStudent(Student student);
    Student updateStudent(String studentId, Student student);
    Student getStudent(String studentId);
    Student deleteStudent(String studentId);
    List<Student> getAll();
}
