package com.huma.domain;

import lombok.Data;

import java.util.List;

@Data
public class Word {
    private String org;
    private String code;
    private String diff;
    private String py;
    private String uini;
    private String  zits;
    private String yets;
    public Word() {

    }
    public Word(String[] list) {
        this.org = list[0];
        this.code = list[1];
        this.diff = list[2];
        this.py = list[3];
        this.uini = list[4];
        this.zits = list[5];
        this.yets = list[6];

    }
}
