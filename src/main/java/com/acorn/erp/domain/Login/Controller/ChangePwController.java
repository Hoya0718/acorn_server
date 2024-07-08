package com.acorn.erp.domain.Login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Login.Service.ChangePwService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ChangePwController {
    
    @Autowired
    private ChangePwService changePwService;
    
    @PatchMapping("/changePw")
    public String putChangePw(@RequestParam("password") String password, @RequestParam("registrationNum") String registrationNum) {
        return changePwService.putChangePw(password, registrationNum);
    }
}