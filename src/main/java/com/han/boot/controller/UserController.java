package com.han.boot.controller;

import com.han.boot.bean.User;
import com.han.boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping
    public List<User> getAll(){
        return iUserService.list();
    }
}
