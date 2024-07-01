package com.acorn.erp.domain.Login.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Login.Entity.*;

@Mapper
public interface UserInfoMapper {
	@Select("select * from userinfo")
	List<userInfo> getAllUserInfo();
	
	@Insert("insert into userInfo(email, password, shopName, registrationNum) values(#{email}, #{password}, #{shopName}, #{registrationNum})")
	void insertUserInfo(userInfo userinfo); 
	
	@Delete("DELETE FROM userinfo WHERE email =#{email}")
    void deleteUserInfo(String email);
	
	@Update("UPDATE userInfo SET password = #{password} WHERE email =#{email}")
	void updateUserInfo(userInfo userinfo);
	
	
}
	