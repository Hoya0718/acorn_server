package com.acorn.erp.domain.Customer.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Customer.Entity.AgeGroup;
import com.acorn.erp.domain.Customer.Entity.CustomerGrade;
import com.acorn.erp.domain.Customer.Entity.CustomerInfo;
import com.acorn.erp.domain.Customer.Repository.AgeGroupRepository;
import com.acorn.erp.domain.Customer.Repository.CustomerInfoRepository;
import com.acorn.erp.domain.Customer.Service.CustomerDataService;
import com.acorn.erp.domain.Customer.Service.GradeService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerInfoRepository repository;
	@Autowired
	private AgeGroupRepository ageRepository;
	@Autowired
	private CustomerDataService service;
	@Autowired
	private GradeService gradeService;

	@GetMapping("/getCountAll")
	public int countAll() {
		List<CustomerInfo> users = repository.findAll();
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

	@PostMapping("/getCountAll")
	public Map<String, Map<String, Map<String, Long>>> countCustomerGroupBy() {
		List<CustomerInfo> customers = repository.findAll();

		// 성별 등급별로 구분해서 합계구하기
		Map<Integer, String> customerGenderMap = customers.stream()
				.collect(Collectors.toMap(CustomerInfo::getCustomerId, customer -> {
					CustomerGrade grade = service.getGradeByCustomerId(customer.getCustomerId());
					return grade != null ? grade.getCustomerGrade() : "Unknown";
				}));

		Map<String, Map<String, Long>> countsByGenderAndGrade = customers.stream()
				.collect(Collectors.groupingBy(CustomerInfo::getCustomerGender, Collectors.groupingBy(
						customer -> customerGenderMap.get(customer.getCustomerId()), Collectors.counting())));
		
		// 연령별등급별로 구분해서 합계구하기
		List<AgeGroup> ageGroup = ageRepository.findAll();
		// 고객 ID를 기준으로 나이 그룹을 매핑함
		Map<Integer, String> customerAgeMap = customers.stream()
				.collect(Collectors.toMap(CustomerInfo::getCustomerId, customer -> {
					List<AgeGroup> ageGroups = ageRepository.findByCustomerId(customer.getCustomerId());
					return ageGroups != null && !ageGroups.isEmpty() ? ageGroups.get(0).getAgeGroup() : "Unknown";
				}));
		// 고객 ID를 기준으로 등급을 매핑함
		Map<Integer, String> customerGradeMap = customers.stream()
				.collect(Collectors.toMap(CustomerInfo::getCustomerId, customer -> {
					CustomerGrade grade = service.getGradeByCustomerId(customer.getCustomerId());
					return grade != null ? grade.getCustomerGrade() : "Unknown";
				}));
		// 고객 정보를 나이 그룹과 등급 정보로 결합
		Map<Integer, Map<String, String>> customerInfoMap = customers.stream()
	            .collect(Collectors.toMap(CustomerInfo::getCustomerId, customer -> {
	                Map<String, String> infoMap = new HashMap<>();
	                infoMap.put("ageGroup", customerAgeMap.get(customer.getCustomerId()));
	                infoMap.put("grade", customerGradeMap.get(customer.getCustomerId()));
	                return infoMap;
	            }));
		
	       Map<String, Map<String, Long>> countsByAgeAndGrade = customers.stream()
	                .collect(Collectors.groupingBy(customer -> customerAgeMap.get(customer.getCustomerId()), 
	                        Collectors.groupingBy(customer -> customerGradeMap.get(customer.getCustomerId()), 
	                                Collectors.counting())));
	       
		// 지역별등급별로 구분해서 합계구하기
		Map<Integer, String> customerRegionMap = customers.stream()
				.collect(Collectors.toMap(CustomerInfo::getCustomerId, customer -> {
					CustomerGrade grade = service.getGradeByCustomerId(customer.getCustomerId());
					return grade != null ? grade.getCustomerGrade() : "Unknown";
				}));

		Map<String, Map<String, Long>> countsByRegionAndGrade = customers.stream()
				.collect(Collectors.groupingBy(CustomerInfo::getCustomerGender, Collectors.groupingBy(
						customer -> customerRegionMap.get(customer.getCustomerId()), Collectors.counting())));

		Map<String, Map<String, Map<String, Long>>> result = new HashMap<>();
		result.put("gender", countsByGenderAndGrade);
		result.put("age", countsByAgeAndGrade);
		result.put("region", countsByRegionAndGrade);

		return result;
	}

	// 기본등급 일괄 적용
	@PostConstruct
	public void init() {
		gradeService.applyDefaultGradeToExistingCustomers();
	}
}
