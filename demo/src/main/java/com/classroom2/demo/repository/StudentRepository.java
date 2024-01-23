package com.classroom2.demo.repository;
import com.classroom2.demo.models.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Transactional
@Repository
public class StudentRepository implements IStudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Student getStudent(String studentId){

        Student student = entityManager.find(Student.class, studentId);
        return student;
    }

    @Override
    public Student createStudent(Student student) {
        String email= student.getEmail();
        Boolean isValid = validateStudentEnail(email);

        if (isValid==true){
            UUID uuid = UUID.randomUUID();
            String studentUuid = uuid.toString();
            student.setStudentId(studentUuid);
            entityManager.persist(student);
            return student;
        }
        else {
            return null;
        }
    }

    @Override
    public Student getStudentById(String id){
        String sql = "SELECT * FROM students WHERE StudentId = ?";
        Query query = entityManager.createNativeQuery(sql, Student.class);
        query.setParameter(1, id);

        return (Student) query.getSingleResult();
    }

    @Override
    public Student updateStudent(String studentId, Student student){
        Student studentFromDb = getStudentByFromDb(studentId);
        studentFromDb.setName(student.getName());
        studentFromDb.setPhone(student.getPhone());
        studentFromDb.setAddress(student.getAddress());
        studentFromDb.setLastName(student.getLastName());
        studentFromDb.setEmail(student.getEmail());

        entityManager.flush();

        Student updatedStudent = getStudentByFromDb(studentId);

        return updatedStudent;
    }
    @Override
    public Student deleteStudent(String studentId){

        Student studentFromDb = getStudentByFromDb(studentId);
        studentFromDb.setEnable(false);

        Student studentDeleted = getStudentByFromDb(studentId);

        return studentDeleted;
    }

    @Override
    public List<Student> getAll(){
        String sql = "SELECT * FROM students";
        Query query = entityManager.createNativeQuery(sql, Student.class);
        List<Student> students = query.getResultList();

        return students;
    }
    private Student getStudentByFromDb(String id){
        String sql = "SELECT * FROM students WHERE StudentId = ?";
        Query query = entityManager.createNativeQuery(sql, Student.class);
        query.setParameter(1, id);

        return (Student) query.getSingleResult();
    }

    private Boolean validateStudentEnail(String email){

        try{
            String sql = "SELECT * FROM students WHERE Email = ?";
            Query query = entityManager.createNativeQuery(sql, Student.class);
            query.setParameter(1, email);

            Student student = (Student) query.getSingleResult();

            if (student == null){
                return true;
            }
            return false;
        }catch (Exception e){
            return true;
        }
    }
}
