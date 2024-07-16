package com.JavaApi.springboot_Curd.service;

import com.JavaApi.springboot_Curd.dto.StudentDTO;
import com.JavaApi.springboot_Curd.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    List<Student> getStudents();

    Student getStudent(Integer id);

    void updateStudent(Integer id, Student student);

    void deleteStudent(Integer id);

    void updateName(Integer id, StudentDTO studentDTO);
}
