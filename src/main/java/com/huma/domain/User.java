package com.huma.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Data
@TableName("users")
public class User {


    private String account;
    private String passwd;
    private String uname;
    private double score;
    private int topchi;

//    public User(String account, String passwd) {
//        this.account = account;
//        this.passwd = passwd;
//    }
//
//    public User() {
//    }
//
//    public User(String account, String passwd, String uname, double score, int topchi) {
//        this.account = account;
//        this.passwd = passwd;
//        this.uname = uname;
//        this.score = score;
//        this.topchi = topchi;
//    }
}
