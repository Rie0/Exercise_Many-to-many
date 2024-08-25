package org.twspring.exercisejparelationi.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.twspring.exercisejparelationi.Model.Course;
import org.twspring.exercisejparelationi.Service.CourseService;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }
    @GetMapping("/get-teacher-name/{id}")
    public ResponseEntity getTeacherName(@PathVariable int id) {
        return ResponseEntity.status(200).body(courseService.getTeacherName(id));
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Course added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse( @PathVariable Integer id,
                                        @Valid @RequestBody Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body("Course updated");
    }
    @PutMapping("/{id}/assign-to/{teacherId}")
    public ResponseEntity assignCourseToTeacher(@PathVariable Integer id,
                                                @PathVariable Integer teacherId) {
        courseService.AssignTeacher(id, teacherId);
        return ResponseEntity.status(200).body("Course assigned");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course deleted");
    }
}
