package com.acorn.erp.domain.Financial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialService {
	@Autowired
	private FinancialMapper examMapper;
	
	public List<Financial> getAllExam(){
		return examMapper.getAllExam();
	}
	
	public Financial getNExam(int id){
		return examMapper.getNExam(id);
	}
	
	public void insertExam(Financial exam) {
		examMapper.insertExam(exam);
	}
	
	public void deleteExam(int id) {
		examMapper.deleteExam(id);
	}
	
	public void updateExam(Financial exam) {
        examMapper.updateExam(exam);
        System.out.println("서비스 성공");
    }
}
