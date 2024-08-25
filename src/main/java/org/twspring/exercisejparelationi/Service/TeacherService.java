package org.twspring.exercisejparelationi.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.twspring.exercisejparelationi.Api.ApiException;
import org.twspring.exercisejparelationi.Model.Teacher;
import org.twspring.exercisejparelationi.Repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        return teacher;
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher t = teacherRepository.findTeacherById(id);
        if (t == null) {
            throw new ApiException("Teacher with id " + id + " not found");
        }
        t.setName(teacher.getName());
        t.setAge(teacher.getAge());
        t.setEmail(teacher.getEmail());
        t.setSalary(teacher.getSalary());
        teacherRepository.save(t);
    }

    public void deleteTeacher(Integer id) {
        Teacher t = teacherRepository.findTeacherById(id);
        if (t == null) {
            throw new ApiException("Teacher with id " + id + " not found");
        }
        teacherRepository.delete(t);
    }
}
