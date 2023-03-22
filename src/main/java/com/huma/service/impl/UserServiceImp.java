package com.huma.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huma.Dao.UserDao;
import com.huma.domain.User;
import com.huma.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp extends ServiceImpl<UserDao, User> implements IUserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getByAccount(String account) {
        return userDao.getByAccount(account);
    }

    @Override
    public boolean deleteByAccount(String account) {
        return userDao.deleteByAccount(account) > 0;
    }

    @Override
    public  User getByUname(String uname) {
        return userDao.getByUname(uname);
    }

    @Override
    public boolean updateByAccount(User user) {
        return userDao.updateByAccount(user) > 0;
    }
}

