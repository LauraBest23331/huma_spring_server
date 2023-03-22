package com.huma.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huma.Dao.UserDao;
import com.huma.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTestCase {
    @Autowired
    private UserDao userDao;

    @Test
    void testGetById() {
        System.out.println(userDao.getByAccount("18111002318"));
    }
    @Test
    void save() {
        User user = new User();
        user.setUname("test");
        user.setAccount("testaccount");
        user.setPasswd("123456");
        user.setUname("123");
        user.setTopchi(0);
        user.setScore(0);
        userDao.insert(user);
    }
    @Test
    void delete() {
    }
    @Test
    void getAll() {
        userDao.selectList(null);
    }
    @Test
    void getPage() {
        IPage page = new Page(1, 5);
        userDao.selectPage(page, null);
    }
}
