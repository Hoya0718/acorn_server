package com.acorn.erp.domain.Login.Repository;

/*
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Login.Entity.UserInfo;


/*
@Mapper
public interface FindPwRepository {
    @Select("SELECT registrationNum FROM userinfo WHERE registrationNum = #{registrationNum} AND email = #{email}")
    String getFindPw(@Param("registrationNum") String registrationNum, @Param("email") String email);
*/

@Repository
// @Modifying은 데이터를 수정하는 UPDATE나 DELETE 쿼리에서 사용됨
// @Transactional은 데이터베이스 트랜잭션을 처리할 때 사용됨
public interface FindPwRepository extends JpaRepository<UserInfo, Long> {
    @Query("SELECT u.registrationNum FROM UserInfo u WHERE u.registrationNum = :registrationNum AND u.email = :email")
    String getFindPw(@Param("registrationNum") String registrationNum, @Param("email") String email);
}