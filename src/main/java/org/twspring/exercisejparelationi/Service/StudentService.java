package org.twspring.exercisejparelationi.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.twspring.exercisejparelationi.Api.ApiException;
import org.twspring.exercisejparelationi.Model.Course;
import org.twspring.exercisejparelationi.Model.Student;
import org.twspring.exercisejparelationi.Repository.CourseRepository;
import org.twspring.exercisejparelationi.Repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByCourse(Integer courseId) {
        Course c=courseRepository.getCourseById(courseId);
        if (c==null){
            throw new ApiException("Course not found");
        }
        List<Student> students = new ArrayList<>(c.getStudents());
        if (students.isEmpty()){
            throw new ApiException("No Students found");
        }
        return students;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student) {
        Student s=studentRepository.findStudentById(id);
        if (s==null){
            throw new ApiException("Student not found");
        }
        s.setName(student.getName());
        s.setAge(student.getAge());
        s.setMajor(student.getMajor());
        studentRepository.save(s);
    }

    public void assignStudentToCourse(Integer id, Integer courseId) {
        Student s=studentRepository.findStudentById(id);
        if(s==null){
            throw new ApiException("Student not found");
        }
        Course c=courseRepository.getCourseById(courseId);
        if(c==null){
            throw new ApiException("Course not found");
        }
        s.getCourses().add(c);
        c.getStudents().add(s);
        courseRepository.save(c);
        studentRepository.save(s);
    }

    public void changeMajor(Integer id, String major) {
        Student s=studentRepository.findStudentById(id);
        if(s==null){
            throw new ApiException("Student not found");
        }
        s.setMajor(major);
        s.getCourses().clear();
        studentRepository.save(s);

        for(Course c:courseRepository.findAll()){
            c.getStudents().remove(s);
            courseRepository.save(c);
        }

    }

    public void deleteStudent(Integer id) {
        Student s=studentRepository.findStudentById(id);
        if (s==null){
            throw new ApiException("Student not found");
        }
        studentRepository.delete(s);
    }
}
