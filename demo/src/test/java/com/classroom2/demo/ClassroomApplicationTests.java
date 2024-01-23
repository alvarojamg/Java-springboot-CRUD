package com.classroom2.demo;

import com.classroom2.demo.controller.StudentController;
import com.classroom2.demo.models.Student;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.classroom2.demo.repository.StudentRepository;
import com.classroom2.demo.repository.StudentRepository;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
public class ClassroomApplicationTests {
	@Autowired
	private StudentController studentController;
	MockMvc mockMvc;

	@Test
	public void  POSTTest() throws  Exception{
		mockMvc.perform(post("/")

		);
	}
	@Test
	public  void GETTest1() throws  Exception{
		assertThat(studentController.getAllStudents()).isNotNull();
	}

	@Test
	public void GETALLTest2() throws Exception{
		List<Student> stu = studentController.getAllStudents();

		for(Student student: stu){
			boolean stud = student.getEmail().isBlank();
			assertThat(stud).isFalse();
		}
		assertThat(stu).isNotNull();
	}
}
