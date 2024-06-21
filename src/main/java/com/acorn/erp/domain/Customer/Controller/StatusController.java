package com.acorn.erp.domain.Customer.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.acorn.erp.domain.Exam.Entity.Exam;
import com.acorn.erp.domain.Exam.Service.ExamService;

@CrossOrigin(origins = "http://localhost:3000") //3000번 포트의 접근은 허락한다.
@RestController
@RequestMapping("/customer_status")
public class StatusController {
	@Autowired
	private StatusService statusService;
	@GetMapping("/exam")
	public List<Exam> getAllEmployees(){
		System.out.println("실행");
		return statusService.getAllExam();
	}
}
