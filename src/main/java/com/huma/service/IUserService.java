package com.huma.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huma.domain.User;

public interface IUserService extends IService<User> {
    User getByAccount(String account);

    boolean deleteByAccount(String account);

    User getByUname(String uname);

    boolean updateByAccount(User user);
}
