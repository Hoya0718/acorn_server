package com.acorn.erp.domain.Login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.erp.domain.Login.Repository.FindPwRepository;

@Service
public class FindPwService {
    
    private final FindPwRepository findPwRepository;
    
    @Autowired
    public FindPwService(FindPwRepository findPwRepository) {
    	this.findPwRepository = findPwRepository;
    }
    
    public String getFindPw(String registrationNum, String email) {
        return findPwRepository.getFindPw(registrationNum, email);
    }
}