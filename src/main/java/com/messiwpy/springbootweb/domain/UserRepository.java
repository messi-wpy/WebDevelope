package com.messiwpy.springbootweb.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository  extends JpaRepository<UserTest,Long> {


    UserTest findByName(String name);

    UserTest findByNameAndAge(String name, Integer age);

    @Query("from UserTest u where u.name=:name")
    UserTest findUser(@Param("name") String name);
}
