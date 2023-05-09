package com.jong.mopr.controller;

import com.jong.mopr.model.UserModel;
import com.jong.mopr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public ModelAndView goHome(HttpServletRequest request, @AuthenticationPrincipal User user) {

        ModelAndView mav = new ModelAndView();

        UserModel member = userService.getUser(user.getUsername());
        List<UserModel> userList = userService.getUsers();

        mav.addObject("member",member);
        mav.addObject("userList",userList);
        mav.setViewName("content/home");

        return mav;
    }
}
