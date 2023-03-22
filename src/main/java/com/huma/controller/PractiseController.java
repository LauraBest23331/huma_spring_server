package com.huma.controller;

import com.huma.controller.utils.R;
import com.huma.domain.Practise;
import com.huma.service.IPractiseService;
import com.huma.service.impl.PractiseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/practise")
public class PractiseController {

    private final IPractiseService practiseService;
    @Autowired
    public PractiseController(PractiseServiceImp practiseServiceImp) {
        this.practiseService = practiseServiceImp;
    }
    @GetMapping("/{account}")
    public R getByAccount(@PathVariable String account) {
        Practise practise = practiseService.getByAccount(account);
        if (practise != null) {
            return new R(200, "ok", practise);
        }else {
            return new R(201, "failed");
        }
    }
    @PostMapping
    public R save(@RequestBody Practise practise) {
        if (practiseService.addPractise(practise)) {
            return new R(200, "ok");
        }else {
            return new R(201, "fails");
        }
    }

    @DeleteMapping("/{account}")
    public R delete(@PathVariable String account) {
        if (practiseService.deleteByAccount(account)) {
            return new R(200, "ok");
        }else {
            return  new R(201, "failed");
        }

    }
}
