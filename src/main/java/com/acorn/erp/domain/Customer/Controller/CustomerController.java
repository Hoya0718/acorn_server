package com.acorn.erp.domain.Customer.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Customer.Entity.AgeGroup;
import com.acorn.erp.domain.Customer.Entity.CustomerGrade;
import com.acorn.erp.domain.Customer.Entity.CustomerInfo;
import com.acorn.erp.domain.Customer.Entity.RegionGroup;
import com.acorn.erp.domain.Customer.Repository.AgeGroupRepository;
import com.acorn.erp.domain.Customer.Repository.CustomerInfoRepository;
import com.acorn.erp.domain.Customer.Repository.RegionGroupRepository;
import com.acorn.erp.domain.Customer.Service.CustomerDataService;
import com.acorn.erp.domain.Customer.Service.GradeService;

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
	@Autowired
	private RegionGroupRepository regionRepository;
	
	@GetMapping("/getAllList")
	public List<CustomerInfo> getAllList() {
		List<CustomerInfo> users = repository.findAll();
		System.out.println(users);
		return users;
	}
	@PostMapping("/getAllList")
	public Page<CustomerInfo> getAllPageInfo(Model model, Pageable pageable) {
		Page<CustomerInfo> users = repository.findAll(pageable);
		System.out.println(users);
		return users;
	}

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
	public Map<String, Map<String, Map<String, Map<String, Long>>>>   countCustomerGroupBy() {
		List<CustomerInfo> customers = repository.findAll();
		System.out.println("countsByGenderAndGrade: 실행");
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
			// 고객 ID를 기준으로 나이 그룹을 매핑함resultGenderAge
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

		Map<String, Map<String, Long>> countsByAgeAndGrade = customers.stream()
				.collect(Collectors.groupingBy(customer -> customerAgeMap.get(customer.getCustomerId()),
						Collectors.groupingBy(customer -> customerGradeMap.get(customer.getCustomerId()),
								Collectors.counting())));

		// 지역별등급별로 구분해서 합계구하기
		List<RegionGroup> region = regionRepository.findAll();
		
			// 고객 ID를 기준으로 지역 그룹을 매핑함
		 Map<Integer, Map<String, String>> customerRegionMap = customers.stream()
				.collect(Collectors.toMap(CustomerInfo::getCustomerId, customer -> {
					List<RegionGroup> regionGroups = regionRepository.findByCustomerId(customer.getCustomerId());
					if (regionGroups != null && !regionGroups.isEmpty()) {
                        RegionGroup regionObject = regionGroups.get(0);
                        Map<String, String> regionMap = new HashMap<>();
                        regionMap.put("province", regionObject.getRegiongroupProvince());
                        regionMap.put("city", regionObject.getRegiongroupCity());
                        regionMap.put("town", regionObject.getRegiongroupTown());
                        return regionMap;
                    } else {
                        Map<String, String> unknownMap = new HashMap<>();
                        unknownMap.put("province", "Unknown");
                        unknownMap.put("city", "Unknown");
                        unknownMap.put("town", "Unknown");
                        return unknownMap;
                    }
				}));

		// 지역별 등급별 집계
		 Map<String, Map<String, Long>> countsByRegionAndGrade = customers.stream()
                .collect(Collectors.groupingBy(customer -> customerRegionMap.get(customer.getCustomerId()).get("province"), 
                        Collectors.groupingBy(customer -> customerGradeMap.get(customer.getCustomerId()), 
                                Collectors.counting())));
        
        // 시도별 집계
		 Map<String, Map<String, Long>> countsByCityAndGrade = customers.stream()
                .collect(Collectors.groupingBy(customer -> customerRegionMap.get(customer.getCustomerId()).get("city"), 
                        Collectors.groupingBy(customer -> customerGradeMap.get(customer.getCustomerId()), 
                                Collectors.counting())));
        
        // 시군구별 집계
		 Map<String, Map<String, Long>> countsByTownAndGrade = customers.stream()
                .collect(Collectors.groupingBy(customer -> customerRegionMap.get(customer.getCustomerId()).get("town"), 
                        Collectors.groupingBy(customer -> customerGradeMap.get(customer.getCustomerId()), 
                                Collectors.counting())));
		 // 디버그 출력
//	        System.out.println("countsByGenderAndGrade: " + countsByGenderAndGrade);
//	        System.out.println("countsByAgeAndGrade: " + countsByAgeAndGrade);
//	        System.out.println("countsByRegionAndGrade: " + countsByRegionAndGrade);
//	        System.out.println("countsByCityAndGrade: " + countsByCityAndGrade);
//	        System.out.println("countsByTownAndGrade: " + countsByTownAndGrade);
	        
		 Map<String, Map<String, Map<String, Long>>> resultGenderAge = new HashMap<>();
		 resultGenderAge.put("gender", countsByGenderAndGrade);
		 resultGenderAge.put("age", countsByAgeAndGrade);

		 Map<String, Map<String, Map<String, Long>>> regionResult = new HashMap<>();
		 regionResult.put("Province", countsByRegionAndGrade);
		 regionResult.put("City", countsByCityAndGrade);
		 regionResult.put("Town", countsByTownAndGrade);
		 
		 Map<String, Map<String, Map<String, Map<String, Long>>>> result = new HashMap<>();
	        result.put("genderAge", resultGenderAge);
	        result.put("region", regionResult);

		
		 return result;
	}

	// 기본등급 일괄 적용
//	@PostConstruct
//	public void init() {
//		gradeService.applyDefaultGradeToExistingCustomers();
//	}
}
