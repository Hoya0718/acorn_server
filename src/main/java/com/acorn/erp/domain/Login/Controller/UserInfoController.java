package com.acorn.erp.domain.Login.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Login.Entity.userInfo;
import com.acorn.erp.domain.Login.Service.UserInfoService;

@CrossOrigin(origins = "http://localhost:3000") //3000번 포트의 접근은 허락한다.
@RestController
@RequestMapping("/api")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping("/Login")
	public List<userInfo> getAllUser(){
		System.out.println("실행");
		return userInfoService.getAllUserInfo();
	}
	
	@PostMapping("/Login")
	public String insertUserInfo(@RequestBody userInfo userinfo) {
		userInfoService.insertUserInfo(userinfo);
		System.out.println("추가실행");
		return "Success";
	}
	
	@DeleteMapping("/{email}")
	public String deleteExam(@PathVariable("email") String email) {
		userInfoService.deleteUserInfo(email);
		System.out.println("삭제실행");
		return "Success";
	}
	
	@PutMapping("/{email}")
    public String updateExam(@RequestBody userInfo userinfo) {
		userInfoService.updateUserInfo(userinfo);
        return "성공";
    }
}