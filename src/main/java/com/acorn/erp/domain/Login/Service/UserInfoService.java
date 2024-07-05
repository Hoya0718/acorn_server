package com.acorn.erp.domain.Login.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.erp.domain.Login.Entity.userInfo;
import com.acorn.erp.domain.Login.Repository.UserInfoMapper;

@Service
public class UserInfoService {
	
    @Autowired
    private UserInfoMapper userInfoMapper;
	
    public List<userInfo> getAllUserInfo() {
        return userInfoMapper.getAllUserInfo();
    }

    public void insertUserInfo(userInfo userinfo) {
        userInfoMapper.insertUserInfo(userinfo);
    }
	
    public void deleteUserInfo(String email) {
        userInfoMapper.deleteUserInfo(email);
    }
	
    public void updateUserInfo(userInfo userinfo) {
        userInfoMapper.updateUserInfo(userinfo);
        System.out.println("업데이트 성공");
    }
    
    //로그인 관련 매퍼
    
    public UserInfoService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public userInfo login(String email, String password) {
        return userInfoMapper.getUserByEmailAndPassword(email, password);
    }
    
  
    public String getShopname(String shopname) {
    	return userInfoMapper.getShopname(shopname);
    }
}