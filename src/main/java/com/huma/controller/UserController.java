package com.huma.controller;

import com.huma.controller.utils.R;
import com.huma.domain.User;
import com.huma.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;
    @Autowired
    public UserController(IUserService userService) {
        Assert.notNull(userService, "my userService is not null");
        this.userService = userService;
    }

    @PostMapping
    public R save(@RequestBody User user) {
        if (userService.save(user)) {
            return new R(200, "add success");
        }else {
            return new R(201, "failed");
        }

    }
    @PostMapping("/login")
    public R login(@RequestBody User loginUser) {
        User byAccount = userService.getByAccount(loginUser.getAccount());

        if (byAccount!=null) {
            if (byAccount.getPasswd().equals(loginUser.getPasswd())) {
                return new R(200, "ok", byAccount);

            }else {
                return new R(202, "fail!");

            }
        }else {
            return new R(201, "fail");
        }

    }
    @GetMapping
    public R get() {
        List<User> list = userService.list();
        list.forEach(f->f.setPasswd(null));
        if (!list.isEmpty()) {

            return new R(200, "query success", list);
        }else {

            return new R(201, "failed!", list);
        }

    }
    @GetMapping("/isHasName/{uname}")
    public R isHasName(@PathVariable String uname) {
        User byUname = userService.getByUname(uname);
        if (byUname == null) {
            return new R(201, "ok");

        }else {
            return new R(200, "can not find same name");
        }
    }
    @GetMapping("/{account}")
    public R getById(@PathVariable String account) {
        User byAccount = userService.getByAccount(account);
        if (byAccount != null) {
            return new R(200, "query success", byAccount);
        }else {
            return new R(201, "failed");
        }
    }
    @DeleteMapping("/{account}")
    public R delete(@PathVariable String account) {
        if (userService.deleteByAccount(account)) {
            return new R(200, "Delete success!");
        }else {
            return new R(201, "Delete fail!");

        }
    }
    @PutMapping
    public R update(@RequestBody User user) {
        if (userService.updateByAccount(user)) {
            return new R(200, "update success");
        }else {
            return new R(201, "failed!");
        }

    }

}
