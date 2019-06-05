package com.messiwpy.springbootweb.Dao;

import com.messiwpy.springbootweb.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository  extends JpaRepository<Teacher,String> {
}
