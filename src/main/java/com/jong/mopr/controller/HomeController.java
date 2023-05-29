package com.jong.mopr.controller;

import com.jong.mopr.model.CodeModel;
import com.jong.mopr.model.UserModel;
import com.jong.mopr.service.CodeService;
import com.jong.mopr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @Autowired
    CodeService codeService;

    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public ModelAndView goHome(HttpServletRequest request, @AuthenticationPrincipal User user) {

        ModelAndView mav = new ModelAndView();

        UserModel member = userService.getUser(user.getUsername());
        List<UserModel> userList = userService.getUsers();

        mav.addObject("member",member);
        mav.addObject("userList",userList);
        mav.setViewName("content/main");

        return mav;
    }

    @RequestMapping(value = "/manage", method= RequestMethod.GET)
    public ModelAndView goAdminPage(HttpServletRequest request, @AuthenticationPrincipal User user) {

        ModelAndView mav = new ModelAndView();

        UserModel member = userService.getUser(user.getUsername());
        List<UserModel> userList = userService.getUsers();
        HashMap<String,String> map= new HashMap<>();
        //map.put("group_code","admin");
        List<CodeModel> adminMenuList = codeService.getCode(map);

        mav.addObject("member",member);
        mav.addObject("userList",userList);
        mav.addObject("menuList",adminMenuList);
        mav.setViewName("content/admin");

        return mav;
    }

    @RequestMapping(value="/admMenu",method = RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    public ModelAndView getAdmMenu(CodeModel codeModel,  HttpServletRequest request, @AuthenticationPrincipal User user){
        ModelAndView mav = new ModelAndView();
        UserModel member = userService.getUser(user.getUsername());
        List<UserModel> userList = userService.getUsers();
        codeModel.getGroup_code();

        mav.addObject("member",member);
        mav.addObject("userList",userList);

        return mav;
    }


    @RequestMapping(value = "/board", method= RequestMethod.GET)
    public ModelAndView goBoard(HttpServletRequest request, @AuthenticationPrincipal User user) {
        UserModel member = userService.getUser(user.getUsername());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("content/board");
        mv.addObject("member",member);

        return mv;
    }

    @RequestMapping(value = "/board/write", method= RequestMethod.GET)
    public ModelAndView writeBoard(HttpServletRequest request, @AuthenticationPrincipal User user) {
        UserModel member = userService.getUser(user.getUsername());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("content/boardWrite");
        mv.addObject("member",member);

        return mv;
    }
    
    //게시판 등록시키기
    @RequestMapping(value = "/board/insert", method= RequestMethod.GET)
    public ModelAndView insertBoard(HttpServletRequest request, @AuthenticationPrincipal User user) {
        UserModel member = userService.getUser(user.getUsername());

        
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("content/board");
        mv.addObject("member",member);

        return mv;
    }


}
