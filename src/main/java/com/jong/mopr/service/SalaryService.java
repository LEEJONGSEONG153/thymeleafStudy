package com.jong.mopr.service;

import com.jong.mopr.mapper.SalaryMapper;
import com.jong.mopr.model.SalaryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    @Autowired
    public SalaryMapper mapper;

    public List<SalaryModel> getSalary() {
        return mapper.getSalary();
    }

}
