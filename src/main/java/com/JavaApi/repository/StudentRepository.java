package com.JavaApi.springboot_Curd.repository;

import com.JavaApi.springboot_Curd.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
