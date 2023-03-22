package com.huma.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huma.domain.Practise;
import com.huma.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PractiseDao extends BaseMapper<Practise> {
    @Select("select * from practise where account = #{account}")
    Practise getByAccount(String account);
    @Delete("delete from practise where account = #{account}")
    int deleteByAccount(String account);
    @Insert("insert into practise(`account`, `index`, `count`) values(#{account},#{index},#{count})")
    int addPractise(Practise practise);
}
