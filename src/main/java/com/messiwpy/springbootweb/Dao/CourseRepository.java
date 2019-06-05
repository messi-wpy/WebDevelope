package com.messiwpy.springbootweb.Dao;

import com.messiwpy.springbootweb.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,String> {

    Course findDistinctByCourseId(String id);
}
