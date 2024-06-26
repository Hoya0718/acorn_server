package com.acorn.erp.domain.Customer.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn.erp.domain.Customer.Entity.AgeGroup;
import com.acorn.erp.domain.Customer.Entity.CustomerGrade;
import com.acorn.erp.domain.Customer.Entity.CustomerInfo;
import com.acorn.erp.domain.Customer.Repository.CustomerInfoRepository;
import com.acorn.erp.domain.Customer.Repository.GradeRepository;
import com.acorn.erp.domain.Customer.Util.AgeGroupUtil;

@Service
public class GradeService {

	@Autowired
	private CustomerInfoRepository customerInfoRepository;

	@Autowired
	private GradeRepository gradeRepository;

	// 기존 고객들에게 "일반" 등급 일괄 적용
	 @Transactional
	public void applyDefaultGradeToExistingCustomers() {
		List<CustomerInfo> customers = customerInfoRepository.findAll();

		for (CustomerInfo customer : customers) {
			// 이미 등급이 설정되어 있는 고객은 제외
			if (!gradeRepository.existsByCustomerId(customer.getCustomerId())) {
				CustomerGrade customerGrade = new CustomerGrade(customer.getCustomerId());
				gradeRepository.save(customerGrade);
			}
		}
	}

	// 신규 고객에게 "일반" 등급 적용
	@Transactional
	public void applyDefaultGradeToNewCustomer(CustomerInfo newCustomer) {
		CustomerGrade customerGrade = new CustomerGrade(newCustomer.getCustomerId());
		gradeRepository.save(customerGrade);
	}
}
