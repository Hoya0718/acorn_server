package com.acorn.erp.domain.Login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.acorn.erp.domain.Login.Repository.ChangePwRepository;

@Service
public class ChangePwService {

    private final ChangePwRepository changePwRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ChangePwService(ChangePwRepository changePwRepository, PasswordEncoder passwordEncoder) {
        this.changePwRepository = changePwRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public String updatePassword(String password, String registrationNum) {
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println("Encoded Password: " + encodedPassword);
        System.out.println("Registration Number: " + registrationNum);
        
        int result = changePwRepository.updatePassword(encodedPassword, registrationNum);
        
        if (result > 0) {
            return "Password changed successfully";
        } else {
            throw new RuntimeException("Failed to change password. User might not exist.");
        }
    }
}