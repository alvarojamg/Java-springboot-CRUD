package com.classroom2.demo.service;

import com.classroom2.demo.models.Response;
import com.classroom2.demo.models.Student;
import com.classroom2.demo.repository.IStudentRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.logging.Logger;

@Service
public class StudentService implements IStudentService{
//    Logger logger = (Logger) LoggerFactory.getLogger(StudentService.class);


    @Autowired
    private IStudentRepository repository;

    @Override
    public List<Student> getStudentList() {
        return null;
    }

    @Override
    public Response createStudent(Student student){
//        logger.info("payload ----{}" + student);

        Student studentRes =  repository.createStudent(student);

        if (studentRes != null){
            Response response = new Response();
            response.setResponse("Correct");
            response.setCode("001.001.001");
            response.setDetail("Student added");
            response.setObject(studentRes);

            return response;
        }else {
            Response response = new Response();
            response.setResponse("Bad");
            response.setCode("001.001.001");
            response.setDetail("Email repeated");

            return  response;
        }
    }

    @Override
    public Student updateStudent(String studentId, Student student) {
//        logger.info("payload ----{}" + student+ "Id:"+ studentId);
        return repository.updateStudent(studentId,student);
    }

    @Override
    public Student getStudent(String studentId){
//        logger.info("payload ----{}" + studentId);
        return repository.getStudentById(studentId);
    }

    @Override
    public Student deleteStudent(String studentId) {
//        logger.info("payload ----{}" + studentId);
        return repository.deleteStudent(studentId);
    }

    @Override
    public List<Student> getAll(){
        return repository.getAll();
    }
}
