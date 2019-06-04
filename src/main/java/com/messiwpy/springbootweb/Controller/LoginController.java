package com.messiwpy.springbootweb.Controller;


import com.messiwpy.springbootweb.Dao.UserRepository;
import com.messiwpy.springbootweb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/login")
public class LoginController  {

    @Autowired
    UserRepository userRepository;
    @PostMapping("/register")
    public ResponseEntity<String> registered(@RequestBody User user){
        if (userRepository.findByAccount(user.getAccount())!=null){
            return ResponseEntity.badRequest()
                    .body("用户名已存在!");

        }else {
            userRepository.save(user);
            return ResponseEntity.ok("注册成功");

        }

    }


}
