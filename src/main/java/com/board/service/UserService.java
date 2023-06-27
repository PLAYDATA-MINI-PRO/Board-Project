package com.board.service;

import com.board.dao.UserDao;
import com.board.domain.requset.SignupRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;

    public Boolean signup(SignupRequest signupRequest) {
        return userDao.signup(signupRequest) != 0;
    }
}
