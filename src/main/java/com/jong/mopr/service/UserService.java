package com.jong.mopr.service;

import com.jong.mopr.mapper.SalaryMapper;
import com.jong.mopr.mapper.UserMapper;
import com.jong.mopr.model.SalaryModel;
import com.jong.mopr.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;

    public UserModel getUser(String id) {
        return userMapper.getUser(id);
    }

    public List<UserModel> getUsers(){
        return userMapper.getUsers();
    }

    public UserModel joinUser(UserModel userModel) {
        return userMapper.joinUser(userModel);
    }

}
