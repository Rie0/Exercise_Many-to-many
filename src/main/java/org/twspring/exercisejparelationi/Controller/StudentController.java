package org.twspring.exercisejparelationi.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.twspring.exercisejparelationi.Model.Student;
import org.twspring.exercisejparelationi.Service.StudentService;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }
    @GetMapping("/get-by-course/{courseId}")
    public ResponseEntity getStudentByCourseId(@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(studentService.getStudentsByCourse(courseId));

    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(201).body("Student added successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id,
                                        @Valid @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("Student updated successfully");
    }
    @PutMapping("/assign-student/{id}/to-course/{courseId}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer id,
                                                @PathVariable Integer courseId) {
        studentService.assignStudentToCourse(id, courseId);
        return ResponseEntity.status(200).body("Student assigned successfully to course");
    }
    @PutMapping("/change-major/{id}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer id,
                                      @PathVariable String major) {
        studentService.changeMajor(id, major);
        return ResponseEntity.status(200).body("Student's major updated successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted successfully");
    }
}
