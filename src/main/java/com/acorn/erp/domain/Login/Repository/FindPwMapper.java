package com.acorn.erp.domain.Login.Repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface FindPwMapper {
    @Select("SELECT password FROM userinfo WHERE registrationNum = #{registrationNum} AND email = #{email}")
    String getFindPw(@Param("registrationNum") String registrationNum, @Param("email") String email);
}