package com.jong.mopr.controller;

import com.jong.mopr.mapper.UserMapper;
import com.jong.mopr.model.SalaryModel;
import com.jong.mopr.model.UserModel;
import com.jong.mopr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
//    @Autowired
//    SalaryService salaryService;

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public ModelAndView goHome(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView();

        List<UserModel> userList = userMapper.getUsers();
        mav.addObject("userList",userList);
        mav.setViewName("content/home");

        return mav;
    }
}
