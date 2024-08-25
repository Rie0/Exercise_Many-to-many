package org.twspring.exercisejparelationi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.twspring.exercisejparelationi.Model.Course;
import org.twspring.exercisejparelationi.Model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentById(Integer id);
}
