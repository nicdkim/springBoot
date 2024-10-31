package com.ohgiraffers.chap08securitysession.user.dao;

import com.ohgiraffers.chap08securitysession.user.dto.LoginUserDTO;
import com.ohgiraffers.chap08securitysession.user.dto.SignUpDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int regist(SignUpDTO signUpDTO);

    LoginUserDTO findByUserName(String username);
}
