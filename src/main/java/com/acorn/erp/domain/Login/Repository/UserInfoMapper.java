package com.acorn.erp.domain.Login.Repository;



import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import com.acorn.erp.domain.Login.Entity.*;

@Mapper
public interface UserInfoMapper {
	
	 @Select("SELECT * FROM USERINFO")
	    List<userInfo> getAllUserInfo();
	
	 @Select("SELECT u FROM userinfo WHERE registrationNum = #{registrationNum} AND email = #{email}")
	 String getFindPw(@Param("registrationNum") String registrationNum, @Param("email") String email);
	
	 @Select("SELECT * FROM userInfo where email = #{email}")
	 userInfo getUserByEmail(String email);
	 	
	 
	@Insert("insert into userInfo(email, password, shopName, registrationNum) values(#{email}, #{password}, #{shopName}, #{registrationNum})")
	void insertUserInfo(userInfo userinfo); 
	
	@Delete("DELETE FROM userinfo WHERE email =#{email}")
    void deleteUserInfo(String email);
	
	@Update("UPDATE userInfo SET password = #{password} WHERE email =#{email}")
	void updateUserInfo(userInfo userinfo);
	
	//로그인 구현
	@Select("SELECT * FROM USERINFO WHERE email = #{email} AND password = #{password}")
    userInfo getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	
	@Select("SELECT shopname from userInfo WHERE email =#{email}")
	 String getShopname(String email);
	
}