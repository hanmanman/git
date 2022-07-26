package com.han.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.han.boot.bean.User;
import com.han.boot.dao.UserDao;
import com.han.boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements IUserService {
    @Autowired
    private UserDao userDao;

}
