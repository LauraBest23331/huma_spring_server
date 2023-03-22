package com.huma.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huma.domain.Practise;
import com.huma.domain.User;

public interface IPractiseService extends IService<Practise> {
    Practise getByAccount(String account);

    boolean deleteByAccount(String account);

    boolean addPractise(Practise practise);
}
