package com.jong.mopr.controller;

import com.jong.mopr.mapper.UserMapper;
import com.jong.mopr.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Common {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/loginPage")
    public String loginPageLoad() {
        return "common/login";
    }

    @RequestMapping(value = "/joinPage")
    public String joinPageLoad() {
        return "common/join";
    }

    @RequestMapping(value = "/join",method = RequestMethod.POST)
    public String join(UserModel userModel) {

        String pw = userModel.getPw();
        String encodedPw = bCryptPasswordEncoder.encode(pw);
        userModel.setPw(encodedPw);
        userMapper.joinUser(userModel);
        return "common/login";
    }
}
