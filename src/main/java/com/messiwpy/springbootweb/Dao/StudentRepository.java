package com.messiwpy.springbootweb.Dao;

import com.messiwpy.springbootweb.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {


    Student findDistinctByStudentId(String student_id);
    Student deleteDistinctByStudentId(String student_id);
}
