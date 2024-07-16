//package com.acorn.erp.domain.Login.Repository;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//import org.springframework.stereotype.Repository;
//
//@Mapper
//public interface FindIdRepository {
//    @Select("SELECT email FROM userinfo WHERE registrationNum = #{registrationNum}")
//    String getFindId(@Param("registrationNum") String registrationNum);
//}

package com.acorn.erp.domain.Login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Login.Entity.UserInfo;

import jakarta.transaction.Transactional;

@Repository
public interface FindIdRepository extends JpaRepository<UserInfo, Long> {

    @Query("SELECT u.email FROM UserInfo u WHERE u.registrationNum = :registrationNum")
    String getFindId(@Param("registrationNum") String registrationNum);

}