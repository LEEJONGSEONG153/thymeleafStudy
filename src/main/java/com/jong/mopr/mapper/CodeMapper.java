package com.jong.mopr.mapper;

import com.jong.mopr.model.CodeModel;
import com.jong.mopr.model.SalaryModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface CodeMapper {

    List<CodeModel> getCode(HashMap<String,String> map);
}
