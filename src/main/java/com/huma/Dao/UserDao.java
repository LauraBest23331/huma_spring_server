package com.huma.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huma.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao extends BaseMapper<User> {
    @Select("select * from users where account = #{account}")
    User getByAccount(String account);
    @Select("select uname from users where uname = #{uname}")
    User getByUname(String uname);
    @Delete( "delete from users where account = #{account}")
    int deleteByAccount(String account);
    @Update("update users set score=#{score}, topchi=#{topchi}, uname=#{uname},passwd=#{passwd} where account=#{account}")
    int updateByAccount(User user);
}
