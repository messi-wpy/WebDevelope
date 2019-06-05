package com.messiwpy.springbootweb.Controller;


import com.messiwpy.springbootweb.Dao.CourseRepository;
import com.messiwpy.springbootweb.Dao.StudentRepository;
import com.messiwpy.springbootweb.Dao.TeacherRepository;
import com.messiwpy.springbootweb.Dao.UserRepository;
import com.messiwpy.springbootweb.domain.Course;
import com.messiwpy.springbootweb.domain.Student;
import com.messiwpy.springbootweb.domain.Teacher;
import com.messiwpy.springbootweb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//http://localhost:8080/
@RestController
@RequestMapping("/info")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CourseRepository courseRe;
    @Autowired
    StudentRepository studentRe;
    @Autowired
    TeacherRepository teacherRep;

    @PutMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        if (studentRe.findDistinctByStudentId(student.getStudentId())!=null)
            return ResponseEntity.badRequest().body("student id 已存在");
        else {
            studentRe.save(student);
            return ResponseEntity.ok("success");
        }
    }

    @PutMapping("/addTeacher")
    public ResponseEntity<String>addTeacher(@RequestBody Teacher teacher){
        teacherRep.save(teacher);
        return ResponseEntity.ok("success");


    }

    @PutMapping("/addCourse")
    public ResponseEntity<String>addCourse(@RequestBody Course course){
        courseRe.save(course);
        return ResponseEntity.ok("success");

    }

    @PostMapping("/getStudents")
    public ResponseEntity<?>getStudents(@RequestBody User user){
        User local=userRepository.findByAccount(user.getAccount());
        if (local==null)
            return ResponseEntity.badRequest().body("用户不存在");
        if (local.getIdentity().equals("teacher")||local.getIdentity().equals("admin")){
            if (!local.getPassword().equals(user.getPassword()))
                return ResponseEntity.badRequest().body("密码错误");
            List<Student> list=studentRe.findAll();
            return ResponseEntity.ok(list);

        }else
            return ResponseEntity.badRequest().body("权限不够");

    }

    @GetMapping("/getCourses")
    public ResponseEntity<?>getCourses(){
        List<Course>list=courseRe.findAll();
        return ResponseEntity.ok(list);

    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?>getStudent(@PathVariable("id") String id){
        Student student=studentRe.findDistinctByStudentId(id);
        if (student==null)
            return ResponseEntity.badRequest().body("student not find");
        return ResponseEntity.ok(student);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<?>getCourse(@PathVariable("id") String id){
        Course course=courseRe.findDistinctByCourseId(id);
        return ResponseEntity.ok(course);

    }

    @DeleteMapping("delete/student/{id}")
    public ResponseEntity<?>deleteStudent(@PathVariable("id") String id){
        if (studentRe.findDistinctByStudentId(id)==null)
            return ResponseEntity.badRequest().body("student not find");
        studentRe.deleteDistinctByStudentId(id);
        return ResponseEntity.ok("delete success");

    }





}
