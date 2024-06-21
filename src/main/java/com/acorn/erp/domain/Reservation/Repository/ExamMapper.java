package com.acorn.erp.domain.Reservation.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Exam.Entity.Exam;

@Mapper
@Repository
public interface ExamMapper {
	@Select("select * from exam")
	List<Exam> getAllExam();
	
	@Select("select * from exam where id = #{id}")
	Exam getNExam(int id);
	
	@Insert("insert into exam(id, useremail, userpassword) values(seq_emp.nextVal, #{useremail}, #{userpassword})")
	void insertExam(Exam exam); 
	
	@Delete("DELETE FROM exam WHERE id =#{id}")
    void deleteExam(int id);
	
	@Update("UPDATE exam SET useremail = #{useremail}, userpassword = #{userpassword} WHERE id =#{id}")
	void updateExam(Exam exam);
}
	