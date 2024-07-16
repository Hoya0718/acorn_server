package com.acorn.erp.domain.Login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn.erp.domain.Login.Entity.UserInfo;
import com.acorn.erp.domain.Login.Repository.UserInfoRepository;

import java.util.List;

@Service
@Transactional
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserInfoService(UserInfoRepository userInfoRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userInfoRepository = userInfoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserInfo> getAllUserInfo() {
        return userInfoRepository.findAll();
    }

    public void insertUserInfo(UserInfo userinfo) {
        // 비밀번호 암호화
        String encryptedPassword = passwordEncoder.encode(userinfo.getPassword());
        userinfo.setPassword(encryptedPassword);
        
        // 사용자 정보 저장
        userInfoRepository.save(userinfo);
    }

    public void deleteUserInfo(String email) {
        userInfoRepository.deleteByEmail(email);
    }

    public void updateUserInfo(UserInfo userinfo) {
        // 비밀번호 암호화
        String encryptedPassword = passwordEncoder.encode(userinfo.getPassword());
        userinfo.setPassword(encryptedPassword);

        userInfoRepository.save(userinfo);
        System.out.println("업데이트 성공");
    }

    public UserInfo login(String email, String password) {
        UserInfo userinfo = userInfoRepository.findByEmail(email);
        if (userinfo != null && passwordEncoder.matches(password, userinfo.getPassword())) {
            return userinfo;
        } else {
            return null;
        }
    }

    public String getShopname(String email) {
        return userInfoRepository.findShopNameByEmail(email);
    }
}