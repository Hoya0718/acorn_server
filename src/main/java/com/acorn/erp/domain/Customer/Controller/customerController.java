package com.acorn.erp.domain.Customer.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Customer.Entity.CustomerInfo;
import com.acorn.erp.domain.Customer.Repository.CustomerInfoRepository;

@RestController
@RequestMapping("/api/customer")
public class customerController {
	@Autowired
	private CustomerInfoRepository repository;
	private static final Logger logger = LoggerFactory.getLogger(CustomerInfo.class);
		@GetMapping("/getCountAll") 
		public int countAll() {
			List<CustomerInfo> users =repository.findAll();
			return users.size();
		}
		@GetMapping("/getCountLastyear") 
		public Long countLastyear(@RequestParam("year") int year) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date endDate = null;
	        try {
	            endDate = dateFormat.parse(year + "-12-31");
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return 0L;
	        }
	        try {
	            long count = repository.countCustomersLastyear(endDate);
	            return count;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return 0L; // 예외 발생 시 0을 반환하거나 적절한 처리
	        }
		}
}
