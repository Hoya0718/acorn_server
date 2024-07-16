package com.acorn.erp.domain.Login.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acorn.erp.domain.Login.Entity.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    List<UserInfo> findAll();

    UserInfo findByEmail(String email);

    void deleteByEmail(String email);

    UserInfo findByEmailAndPassword(String email, String password);

    String findShopNameByEmail(String email);
}

/*
 * @Mapper public interface UserInfoRepository {
 * 
 * @Select("SELECT * FROM USERINFO") List<UserInfo> getAllUserInfo();
 * 
 * @Select("SELECT u FROM userinfo WHERE registrationNum = #{registrationNum} AND email = #{email}"
 * ) String getFindPw(@Param("registrationNum") String
 * registrationNum, @Param("email") String email);
 * 
 * @Select("SELECT * FROM userInfo where email = #{email}") UserInfo
 * getUserByEmail(String email);
 * 
 * 
 * @Insert("insert into userInfo(email, password, shopName, registrationNum) values(#{email}, #{password}, #{shopName}, #{registrationNum})"
 * ) void insertUserInfo(UserInfo userinfo);
 * 
 * @Delete("DELETE FROM userinfo WHERE email =#{email}") void
 * deleteUserInfo(String email);
 * 
 * @Update("UPDATE userInfo SET password = #{password} WHERE email =#{email}")
 * void updateUserInfo(UserInfo userinfo);
 * 
 * //로그인 구현
 * 
 * @Select("SELECT * FROM USERINFO WHERE email = #{email} AND password = #{password}"
 * ) UserInfo getUserByEmailAndPassword(@Param("email") String
 * email, @Param("password") String password);
 * 
 * 
 * @Select("SELECT shopname from userInfo WHERE email =#{email}") String
 * getShopname(String email);
 * 
 */