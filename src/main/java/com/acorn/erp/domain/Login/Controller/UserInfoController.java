package com.acorn.erp.domain.Login.Controller;

import com.acorn.erp.domain.Login.Entity.UserInfo;
import com.acorn.erp.domain.Login.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//세션 추가
import jakarta.servlet.http.HttpSession;

@SessionAttributes("user")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")

public class UserInfoController {

    private final UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("/userinfo")
    public ResponseEntity<UserInfo> getUserInfo(HttpSession session) {
        UserInfo userinfo = (UserInfo) session.getAttribute("user");
        if (userinfo != null) {
            return ResponseEntity.ok(userinfo);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/Login")
    public ResponseEntity<String> insertUserInfo(@RequestBody UserInfo userinfo) {
        userInfoService.insertUserInfo(userinfo);
        System.out.println("추가 실행");
        return ResponseEntity.ok("Success");
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteUserInfo(@PathVariable("email") String email) {
        userInfoService.deleteUserInfo(email);
        System.out.println("삭제 실행");
        return ResponseEntity.ok("Success");
    }

    @PutMapping("/{email}")
    public ResponseEntity<String> updateUserInfo(@PathVariable("email") String email, @RequestBody UserInfo userinfo) {
        userinfo.setEmail(email); // PathVariable을 이용해 email 설정
        userInfoService.updateUserInfo(userinfo);
        System.out.println("업데이트 실행");
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/signin")
    public ResponseEntity<UserInfo> login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        System.out.println("로그인 시도: " + email);

        // 입력된 이메일과 비밀번호가 null 또는 빈 값인지 확인
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("이메일 또는 비밀번호가 입력되지 않음");
            return ResponseEntity.badRequest().build();
        }

        UserInfo userinfo = userInfoService.login(email, password);
        if (userinfo != null) {
            System.out.println("로그인 성공");
            session.setAttribute("user", userinfo);
            System.out.println("세션 값: " + userinfo);
            return ResponseEntity.ok(userinfo);
        } else {
            System.out.println("로그인 실패 - 이메일 또는 비밀번호가 올바르지 않음");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("로그아웃 성공");
    }

    @GetMapping("/getShopname")
    public ResponseEntity<String> getShopname(@RequestParam("email") String email) {
        String shopname = userInfoService.getShopname(email);
        if (shopname != null) {
            return ResponseEntity.ok(shopname);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
