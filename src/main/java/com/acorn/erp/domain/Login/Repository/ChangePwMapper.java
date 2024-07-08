package com.acorn.erp.domain.Login.Repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
public interface ChangePwMapper {
    @Update("UPDATE userinfo SET password = #{password} WHERE registrationNum = #{registrationNum}")
    int putChangePw(@Param("password") String password, @Param("registrationNum") String registrationNum);
}