package com.acorn.erp.domain.Financial;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FinancialMapper {
	@Select("select * from exam")
	List<Financial> getAllExam();
	
	@Select("select * from exam where id = #{id}")
	Financial getNExam(int id);
	
	@Insert("insert into exam(id, useremail, userpassword) values(seq_emp.nextVal, #{useremail}, #{userpassword})")
	void insertExam(Financial exam); 
	
	@Delete("DELETE FROM exam WHERE id =#{id}")
    void deleteExam(int id);
	
	@Update("UPDATE exam SET useremail = #{useremail}, userpassword = #{userpassword} WHERE id =#{id}")
	void updateExam(Financial exam);
}
	