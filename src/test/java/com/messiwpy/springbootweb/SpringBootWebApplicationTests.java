package com.messiwpy.springbootweb;

import com.messiwpy.springbootweb.Dao.CourseRepository;
import com.messiwpy.springbootweb.Dao.UserRepository;
import com.messiwpy.springbootweb.Dao.UserTestRepository;
import com.messiwpy.springbootweb.domain.Course;
import com.messiwpy.springbootweb.domain.User;
import com.messiwpy.springbootweb.domain.UserTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebApplicationTests {

    @Autowired
    private UserTestRepository userTestRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void courseTest(){
        Course course=new Course("计算机科学","123asdsaf");
        courseRepository.save(course);
    }

    @Test
    public void loginTest(){
        User user=new User();
        user.setAccount("123141");
        user.setIdentity("student");
        user.setPassword("asdasd");
        userRepository.save(user);

    }
    @Test
    public void dataBaseTest() throws Exception{
        /*
        userTestRepository.save(new UserTest("wpy",20));
        userTestRepository.save(new UserTest("BBB", 20));
        userTestRepository.save(new UserTest("CCC", 30));
        userTestRepository.save(new UserTest("DDD", 40));
        userTestRepository.save(new UserTest("EEE", 50));
        userTestRepository.save(new UserTest("FFF", 60));
        userTestRepository.save(new UserTest("GGG", 70));
        userTestRepository.save(new UserTest("HHH", 80));
        userTestRepository.save(new UserTest("III", 90));
        userTestRepository.save(new UserTest("JJJ", 100));
*/
        // 测试findAll, 查询所有记录
        //Assert.assertEquals(10, userTestRepository.findAll().size());

        // 测试findByName, 查询姓名为FFF的User
        Assert.assertEquals(60, userTestRepository.findByName("FFF").get(0).getAge().longValue());
        UserTest test= userTestRepository.findByAge(454);
        // 测试findUser, 查询姓名为FFF的User
        Assert.assertEquals(60, userTestRepository.findUser("FFF").get(0).getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        Assert.assertEquals("FFF", userTestRepository.findByNameAndAge("FFF", 60).get(0).getName());

        // 测试删除姓名为AAA的User
        userTestRepository.delete(userTestRepository.findByName("CCC").get(0));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        //Assert.assertEquals(9, userTestRepository.findAll().size());

    }

}
