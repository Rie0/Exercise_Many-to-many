package org.twspring.exercisejparelationi.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.twspring.exercisejparelationi.Api.ApiException;
import org.twspring.exercisejparelationi.Model.Course;
import org.twspring.exercisejparelationi.Model.Teacher;
import org.twspring.exercisejparelationi.Repository.CourseRepository;
import org.twspring.exercisejparelationi.Repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public String getTeacherName(Integer id) {
        Course c= courseRepository.getCourseById(id);
        if (c==null){
            throw new ApiException("Course not found");
        }
        Teacher t= c.getTeacher();
        if (t==null){
            throw new ApiException("No teacher is assigned to this course");
        }
        return t.getName();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Integer id,Course course) {
        Course c=courseRepository.getCourseById(id);
        if (c==null){
            throw new ApiException("Course not found");
        }
        c.setName(course.getName());
        courseRepository.save(c);
    }
    public void AssignTeacher(Integer id, Integer teacherId) {
        Course c= courseRepository.getCourseById(id);
        if (c==null){
            throw new ApiException("Course not found");
        }
        Teacher t= teacherRepository.findTeacherById(teacherId);
        if(t==null){
            throw new ApiException("Teacher not found");
        }
        c.setTeacher(t);
        courseRepository.save(c);
    }
    public void deleteCourse(Integer id) {
        Course c=courseRepository.getCourseById(id);
        if (c==null){
            throw new ApiException("Course not found");
        }
        courseRepository.delete(c);
    }


}
