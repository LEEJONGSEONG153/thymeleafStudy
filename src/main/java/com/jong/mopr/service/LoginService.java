package com.jong.mopr.service;

import com.jong.mopr.mapper.UserMapper;
import com.jong.mopr.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoginService implements UserDetailsService {

    @Autowired
    public UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        UserModel user= userMapper.getUser(id);
        UserModel user2 = UserModel.builder()
                .id(user.getId())
                .pw(user.getPw())
                .role(user.getRole())
                .name(user.getName())
                .email(user.getEmail())
                .build();
        return user2;
    }

}
