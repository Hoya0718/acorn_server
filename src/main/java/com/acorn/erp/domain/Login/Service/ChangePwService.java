package com.acorn.erp.domain.Login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acorn.erp.domain.Login.Repository.ChangePwMapper;

@Service
public class ChangePwService {

    @Autowired
    private ChangePwMapper changePwMapper;

    public String putChangePw(String password, String registrationNum) {
        int result = changePwMapper.putChangePw(password, registrationNum);
        return result > 0 ? "Password changed successfully" : "Failed to change password";
    }
}