package com.classroom2.demo.repository;


import com.classroom2.demo.models.Student;

import java.util.List;


public interface IStudentRepository {
    Student getStudent(String studentId);
    Student createStudent(Student student);

    Student getStudentById(String id);

    Student updateStudent(String studentId, Student student);

    Student deleteStudent(String studentId);

    List<Student> getAll();
}
