package com.acorn.erp.domain.Login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.acorn.erp.domain.Login.Entity.UserInfo;

@Repository
public interface ChangePwRepository extends JpaRepository<UserInfo, Long> {
    @Modifying
    @Query("UPDATE UserInfo u SET u.password = :password WHERE u.registrationNum = :registrationNum")
    int updatePassword(@Param("password") String password, @Param("registrationNum") String registrationNum);
}