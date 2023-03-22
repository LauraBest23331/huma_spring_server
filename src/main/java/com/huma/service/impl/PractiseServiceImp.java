package com.huma.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huma.Dao.PractiseDao;
import com.huma.domain.Practise;
import com.huma.service.IPractiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PractiseServiceImp extends ServiceImpl<PractiseDao, Practise> implements IPractiseService {
    @Autowired
    private PractiseDao practiseDao;
    @Override
    public Practise getByAccount(String account) {
        return practiseDao.getByAccount(account);
    }

    @Override
    public boolean deleteByAccount(String account) {
        return practiseDao.deleteByAccount(account) > 0;
    }

    @Override
    public boolean addPractise(Practise practise) {
        return practiseDao.addPractise(practise) > 0;
    }
}
