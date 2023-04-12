package com.jong.mopr.controller;

import com.jong.mopr.model.SalaryModel;
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
    @Autowired
    SalaryService salaryService;

    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public ModelAndView goHome(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView();

        List<SalaryModel> salaryList = salaryService.getSalary();


//
//        //Salary model
//        //SalaryModel salaryModel = new SalaryModel();
//        SalaryModel salaryModel;
//
//        // 첫 번째 데이터
//        salaryModel = SalaryModel.builder()
//                .id(1)
//                .name("AAA")
//                .email("AAA@example.com").build();
//        salaryList.add(salaryModel);
//
//        // 두 번째 데이터
//        salaryModel = SalaryModel.builder()
//                .id(2)
//                .email("BBB@example.com").build();
//        salaryList.add(salaryModel);
//
//
//        // 세 번째 데이터
//        salaryModel = SalaryModel.builder()
//                .id(3)
//                .name("CCC")
//                .email("CCC@example.com").build();
//        salaryList.add(salaryModel);
//
////        // 첫 번째 데이터
////        salaryModel = new SalaryModel();
////        salaryModel.setId(1);
////        salaryModel.setName("AAA");
////        salaryModel.setEmail("AAA@example.com");
////        salaryList.add(salaryModel);
////
////
////        // 두 번째 데이터
////        salaryModel = new SalaryModel();
////        salaryModel.setId(2);
////        salaryModel.setName("BBB");
////        salaryModel.setEmail("BBB@example.com");
////        salaryList.add(salaryModel);
////
////
////        // 세 번째 데이터
////        salaryModel = new SalaryModel();
////        salaryModel.setId(3);
////        salaryModel.setName("CCC");
////        salaryModel.setEmail("CCC@example.com");
////        salaryList.add(salaryModel);
//

        mav.addObject("salaryList",salaryList);
        mav.setViewName("content/home");

        return mav;
    }
}
