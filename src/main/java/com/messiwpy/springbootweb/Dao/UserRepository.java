package com.messiwpy.springbootweb.Dao;

import com.messiwpy.springbootweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findByAccount(String account);


}
