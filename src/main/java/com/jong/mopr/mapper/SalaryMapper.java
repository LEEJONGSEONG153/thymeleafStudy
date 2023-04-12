package com.jong.mopr.mapper;

import com.jong.mopr.model.SalaryModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SalaryMapper {

    List<SalaryModel> getSalary();
}
