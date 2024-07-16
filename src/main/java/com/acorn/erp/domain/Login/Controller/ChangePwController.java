package com.acorn.erp.domain.Login.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private final ChangePwService changePwService;

    public ChangePwController(ChangePwService changePwService) {
        this.changePwService = changePwService;
    }

    @PatchMapping("changePw")
    public ResponseEntity<?> updatePassword(@RequestParam("password") String password, @RequestParam("registrationNum") String registrationNum) {
        if (!isValidPassword(password) || !isValidRegistrationNum(registrationNum)) {
            return ResponseEntity.badRequest().body("Invalid input");
        } else {
            System.out.println("registrationNum 값: " + registrationNum);
        }
        try {
            String result = changePwService.updatePassword(password, registrationNum);
            System.out.println("비밀번호 변경 성공: " + result);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            System.out.println("비밀번호 변경 실패: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            System.out.println("비밀번호 변경 중 에러 발생: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating password");
        }
    }

    private boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{3,16}$");
    }

    private boolean isValidRegistrationNum(String registrationNum) {
        return registrationNum != null && registrationNum.matches("^[0-9]{10}$");
    }
}