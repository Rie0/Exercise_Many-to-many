package org.twspring.exercisejparelationi.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.twspring.exercisejparelationi.Api.ApiResponse;
import org.twspring.exercisejparelationi.Model.Teacher;
import org.twspring.exercisejparelationi.Service.TeacherService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeachers() {
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getTeacher(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(teacherService.getTeacherById(id));
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid@RequestBody Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted successfully"));
    }
}
