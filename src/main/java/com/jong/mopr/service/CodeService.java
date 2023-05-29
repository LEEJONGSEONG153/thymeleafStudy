package com.jong.mopr.service;

import com.jong.mopr.mapper.CodeMapper;
import com.jong.mopr.model.CodeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CodeService {

    @Autowired
    CodeMapper codeMapper;

    public List<CodeModel> getCode(HashMap<String,String> map){
        return codeMapper.getCode(map);
    }
}
