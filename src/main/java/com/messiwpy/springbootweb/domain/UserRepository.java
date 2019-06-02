package com.messiwpy.springbootweb.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository  extends JpaRepository<UserTest,Long> {


    List<UserTest> findByName(String name);

    List<UserTest> findByNameAndAge(String name, Integer age);

    @Query("from UserTest u where u.name=:name")
    List<UserTest> findUser(@Param("name") String name);
}
