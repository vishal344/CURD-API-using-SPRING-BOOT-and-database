package com.JavaApi.springboot_Curd.controller;

import com.JavaApi.springboot_Curd.dto.StudentDTO;
import com.JavaApi.springboot_Curd.entity.Student;
import com.JavaApi.springboot_Curd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * add student
     */

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);

        return "success add student";
    }

    /**
     * get students as list
     */

    @GetMapping
    public List<Student> getStudents() {
        return StudentService.getStudents();
    }

    /**
     * get student by id
     */

    @GetMapping("/get")
    public Student getStudent(@RequestParam Integer id) {
        return studentService.getStudent(id);
    }

    /**
     * update student
     */

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        studentService.updateStudent(id, student);

        return ResponseEntity.noContent().build();
    }

    /**
     * delete student
     */

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * update name
     */

    @PatchMapping("/update-name/{id}")
    public ResponseEntity<Void> updateName(@PathVariable Integer id, @RequestBody StudentDTO studentDTO){
        studentService.updateName(id, StudentDTO);

        return ResponseEntity.noContent().build();
    }

}
