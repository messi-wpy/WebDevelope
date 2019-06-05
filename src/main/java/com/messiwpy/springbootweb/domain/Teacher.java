package com.messiwpy.springbootweb.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {

    @Id
    @Column(length = 40)
    private String name;
    private String classRoom;
    private String course;

}
