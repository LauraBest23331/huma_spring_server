package com.huma.controller;


import com.huma.controller.utils.R;
import com.huma.domain.Word;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/dic")
public class DicController {

    private List<Word> dicList;
    public DicController() {
        ClassPathResource classPathResource = new ClassPathResource("/static/assets/dic.txt");
        InputStream inputStream = null;
        BufferedReader br = null;
        Scanner scanner = null;
        List<Word> tempList = new ArrayList<Word>();
        try {
            inputStream = classPathResource.getInputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));
            Assert.notNull(br, "is not null");

            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\t");
                Word word = new Word(split);
                tempList.add(word);

            }
            this.dicList = tempList;
            System.out.println("dictionary is loaded successfully!!!");
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    @GetMapping("/{sw}")
    public R get(@PathVariable String sw) {
        R r = new R(201, "failed!");
        this.dicList.forEach(e->{
            if (e.getOrg().equals(sw)) {
                r.setCode(200);
                r.setData(e);
                r.setMsg("find a matching object");
            }
        });

        return r;
    }
}
