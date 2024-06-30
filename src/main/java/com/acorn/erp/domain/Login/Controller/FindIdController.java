package com.acorn.erp.domain.Login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Login.Service.FindIdService;

@CrossOrigin(origins = "http://localhost:3000") //3000번 포트의 접근은 허락한다.
@RestController
@RequestMapping("/api")
public class FindIdController {
    @Autowired
    private FindIdService findIdService;

    @GetMapping("/findEmail/{registrationNum}")
    public String getFindId(String password, @PathVariable("registrationNum") String registrationNum) {
        System.out.println("아이디 찾기 실행");
        return findIdService.getFindId(registrationNum);
    }
}