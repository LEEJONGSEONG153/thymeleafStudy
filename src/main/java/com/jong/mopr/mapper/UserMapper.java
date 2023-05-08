package com.jong.mopr.mapper;

import com.jong.mopr.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface UserMapper {

    UserModel getUser(String id);

    UserModel joinUser(UserModel userModel);
}
