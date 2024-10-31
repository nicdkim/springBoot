package com.ohgiraffers.chap08securitysession.user.service;

import com.ohgiraffers.chap08securitysession.user.dao.UserMapper;
import com.ohgiraffers.chap08securitysession.user.dto.LoginUserDTO;
import com.ohgiraffers.chap08securitysession.user.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder encoder;

    // Transaction - 메소드가 정상적으로 완료되면 커밋함. 실행 중 예외 발생 시 롤백함.
    @Transactional
    public int regist(SignUpDTO signUpDTO) {
        if(signUpDTO.getUserId() == null || signUpDTO.getUserId().isEmpty()) {
            return 0;
        }
        if(signUpDTO.getUsername() == null || signUpDTO.getUsername().isEmpty()) {
            return 0;
        }
        if(signUpDTO.getUserPass() == null || signUpDTO.getUserPass().isEmpty()) {
            return 0;
        }
        signUpDTO.setUserPass(encoder.encode(signUpDTO.getUserPass()));
        int result = userMapper.regist(signUpDTO);

        return result;
    }

    public LoginUserDTO findByUserName(String username) {
        LoginUserDTO login = userMapper.findByUserName(username);
        if(Objects.isNull(login)) {
            return null;
        } else {
            return login;
        }
    }
}
