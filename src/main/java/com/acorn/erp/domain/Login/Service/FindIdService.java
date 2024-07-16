package com.acorn.erp.domain.Login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.erp.domain.Login.Repository.FindIdRepository;

@Service
public class FindIdService {
    
    private final FindIdRepository findIdRepository;
    
    @Autowired
    public FindIdService(FindIdRepository findIdRepository) {
    	this.findIdRepository = findIdRepository;
    }
    
    public String getFindId(String registrationNum) {
    	return findIdRepository.getFindId(registrationNum);
    }
      
}