package com.acorn.erp.domain.Login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.erp.domain.Login.Repository.FindPwMapper;

@Service
public class FindPwService {
    @Autowired
    private FindPwMapper findPwMapper;
    
    public String getFindPw(String registrationNum, String email) {
        return findPwMapper.getFindPw(registrationNum, email);
    }
}