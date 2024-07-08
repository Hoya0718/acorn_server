package com.acorn.erp.domain.Login.Controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.acorn.erp.domain.Login.Entity.userInfo;
import com.acorn.erp.domain.Login.Service.UserInfoService;

//세션 추가
import jakarta.servlet.http.HttpSession;


@CrossOrigin(origins = "http://localhost:3000") //3000번 포트의 접근은 허락한다.
@RestController
@RequestMapping("/api")
@SessionAttributes("user")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	
	 @GetMapping
	    public List<userInfo> getAllUserInfo() {
	        System.out.println("로그인!!!");
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
	
	//로그인 구현
	@PostMapping("/signin")
    public ResponseEntity<userInfo> login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        System.out.println("로그인 시도: " + email);
        userInfo userinfo = userInfoService.login(email, password);
        if (userinfo != null) {
            System.out.println("성공");
            session.setAttribute("user", userinfo);
            System.out.println("세션 값 :" + userinfo);
            return ResponseEntity.ok(userinfo);
        } else {
            System.out.println("실패");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
	
    // id 가져오기
    
    @GetMapping("/userinfo")
    public ResponseEntity<userInfo> getUserInfo(HttpSession session) {
        userInfo userinfo = (userInfo) session.getAttribute("user");
        if (userinfo != null) {
            return ResponseEntity.ok(userinfo);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }



	//로그아웃 구현
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("로그아웃 성공");
    }
	
	//현재 사용자 정보
	@GetMapping("/current-user")
    public userInfo getCurrentUser(HttpSession session) {
        return (userInfo) session.getAttribute("userInfo");
    }
	
	//토스트팝업 내 매장명 정보
	@GetMapping("/getShopname")
	public String getShopname(@RequestParam("email") String email) {
		return userInfoService.getShopname(email);
	}
}