package com.jong.mopr.controller;

import com.jong.mopr.model.UserModel;
import com.jong.mopr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Common {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired

    UserService userService;

    @RequestMapping("/loginPage")
    public String loginPageLoad() {
        return "common/login";
    }

    @RequestMapping(value = "/join",method = RequestMethod.POST)
    public String join(UserModel userModel) {

        String pw = userModel.getPw();
        String encodedPw = bCryptPasswordEncoder.encode(pw);
        userModel.setPw(encodedPw);
        userService.joinUser(userModel);
        return "common/login";
    }
}
