package com.acorn.erp.domain.Reservation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.erp.domain.Exam.Entity.Exam;
import com.acorn.erp.domain.Exam.Repository.ExamMapper;

@Service
public class ResExamService {
	@Autowired
	private ExamMapper examMapper;
	
	public List<Exam> getAllExam(){
		return examMapper.getAllExam();
	}
	
	public Exam getNExam(int id){
		return examMapper.getNExam(id);
	}
	
	public void insertExam(Exam exam) {
		examMapper.insertExam(exam);
	}
	
	public void deleteExam(int id) {
		examMapper.deleteExam(id);
	}
	
	public void updateExam(Exam exam) {
        examMapper.updateExam(exam);
        System.out.println("서비스 성공");
    }
}
