package com.JavaApi.springboot_Curd.service.impl;

import com.JavaApi.springboot_Curd.dto.StudentDTO;
import com.JavaApi.springboot_Curd.entity.Student;
import com.JavaApi.springboot_Curd.repository.StudentRepository;
import com.JavaApi.springboot_Curd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    /**
     * add student
     */
    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    /**
     * get students as list
     */
    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    /**
     * get student by id
     */

    @Override
    public Student getStudent(Integer id) {
//        check weather the student is in database or not
        Student student = studentRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid student Id:" + id));

        return student;
    }

    /**
     * update student
     */

    @Override
    public void updateStudent(Integer id, Student student) {
//        check weather the student is in database or not
        studentRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid student Id:" + id));

        student.setId(id);

        studentRepository.save(student);

    }

    @Override
    public void deleteStudent(Integer id) {
//        check weather the student is in database or not
        Student student = studentRepository
                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid student Id:" + id));

        studentRepository.delete(student);
    }

    @Override
    public void updateName(Integer id, StudentDTO studentDTO) {
//        check weather the student is in database or not
        Student student = studentRepository
                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid student Id:" + id));

        student.setName(studentDTO.getName());

        studentRepository.save(student);

    }
}
