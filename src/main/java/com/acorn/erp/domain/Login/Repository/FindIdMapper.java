package com.acorn.erp.domain.Login.Repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface FindIdMapper {
    @Select("SELECT email FROM userinfo WHERE registrationNum = #{registrationNum}")
    String getFindId(@Param("registrationNum") String registrationNum);
}