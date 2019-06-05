package com.messiwpy.springbootweb.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Student {
    private String name;

    @Id
    @Column(length = 40)
    private String studentId;
    private int age;
    private String sex;
    private String teacher;
    private int year;
    private String degree;
    private String classRoom;
    public Student(){}

    public Student(String student, String studentId, int age, String sex, String teacher, int year, String degree, String classRoom) {
        this.name = student;
        this.studentId = studentId;
        this.age = age;
        this.sex = sex;
        this.teacher = teacher;
        this.year = year;
        this.degree = degree;
        this.classRoom = classRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
}
