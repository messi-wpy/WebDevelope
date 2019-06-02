package com.messiwpy.springbootweb;

import com.messiwpy.springbootweb.domain.UserRepository;
import com.messiwpy.springbootweb.domain.UserTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void dataBaseTest() throws Exception{
        /*
        userRepository.save(new UserTest("wpy",20));
        userRepository.save(new UserTest("BBB", 20));
        userRepository.save(new UserTest("CCC", 30));
        userRepository.save(new UserTest("DDD", 40));
        userRepository.save(new UserTest("EEE", 50));
        userRepository.save(new UserTest("FFF", 60));
        userRepository.save(new UserTest("GGG", 70));
        userRepository.save(new UserTest("HHH", 80));
        userRepository.save(new UserTest("III", 90));
        userRepository.save(new UserTest("JJJ", 100));
*/
        // 测试findAll, 查询所有记录
        //Assert.assertEquals(10, userRepository.findAll().size());

        // 测试findByName, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findByName("FFF").get(0).getAge().longValue());

        // 测试findUser, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findUser("FFF").get(0).getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).get(0).getName());

        // 测试删除姓名为AAA的User
        userRepository.delete(userRepository.findByName("CCC").get(0));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        //Assert.assertEquals(9, userRepository.findAll().size());

    }

}
