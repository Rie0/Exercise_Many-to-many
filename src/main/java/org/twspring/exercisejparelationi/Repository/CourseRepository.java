package org.twspring.exercisejparelationi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.twspring.exercisejparelationi.Model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course getCourseById(Integer id);
}
