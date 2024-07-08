package com.acorn.erp.domain.Login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.erp.domain.Login.Repository.FindIdMapper;

@Service
public class FindIdService {
    @Autowired
    private FindIdMapper findIdMapper;
    
    public String getFindId(String registrationNum) {
        return findIdMapper.getFindId(registrationNum);
    }
}