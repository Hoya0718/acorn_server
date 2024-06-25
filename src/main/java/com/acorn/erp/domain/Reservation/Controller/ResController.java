package com.acorn.erp.domain.Reservation.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Exam.Entity.Exam;
import com.acorn.erp.domain.Exam.Service.ExamService;

@CrossOrigin(origins = "http://localhost:3000") //3000번 포트의 접근은 허락한다.
@RestController
@RequestMapping("/api")
public class ResController {
	@Autowired
	private ExamService examService;
	
	@GetMapping("/exam")
	public List<Exam> getAllEmployees(){
		System.out.println("실행");
		return examService.getAllExam();
	}
	
	@GetMapping("/{id}")
	public Exam getNEmployees(@PathVariable("id")int id){
		return examService.getNExam(id);
	}
	
	
	@PostMapping("/exam")
	public String insertExam(@RequestBody Exam exam) {
		examService.insertExam(exam);
		System.out.println("추가실행");
		return "Success";
	}
	
	@DeleteMapping("/{id}")
	public String deleteExam(@PathVariable("id") int id) {
		examService.deleteExam(id);
		System.out.println("삭제실행");
		return "Success";
	}
	
	@PutMapping("/{id}")
    public String updateExam(@RequestBody Exam exam) {
        examService.updateExam(exam);
        return "성공";
    }
}