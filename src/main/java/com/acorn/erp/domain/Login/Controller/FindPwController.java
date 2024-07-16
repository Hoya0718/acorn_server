package com.acorn.erp.domain.Login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Login.Service.FindPwService;

@CrossOrigin(origins = "http://localhost:3000") //3000번 포트의 접근은 허락한다.
@RestController
@RequestMapping("/api")
public class FindPwController {
    /*
	@Autowired
    private FindPwService findPwService;
	*/
	
	private final FindPwService findPwService;
	
	@Autowired
	public FindPwController(FindPwService findPwService) {
		this.findPwService = findPwService;
	}
	
    @GetMapping("/findPw/{registrationNum}/{email}")
    public String getFindPw(@PathVariable("registrationNum") String registrationNum, @PathVariable("email") String email) {
        System.out.println("비밀번호 찾기 실행 -> 이메일 반환");
        return findPwService.getFindPw(registrationNum, email);
    }
}