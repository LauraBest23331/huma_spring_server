package com.huma.service;

import com.huma.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTestCase {
    @Autowired
    private IUserService userService;

    @Test
    void getAllTest() {
        userService.getByAccount("18111002318");
    }
    @Test
    void addServiceTest() {
        User user = new User();
        user.setUname("test");
        user.setAccount("testaccount");
        user.setPasswd("123456");
        user.setUname("123");
        user.setTopchi(0);
        user.setScore(0);
        userService.save(user);
    }


}
