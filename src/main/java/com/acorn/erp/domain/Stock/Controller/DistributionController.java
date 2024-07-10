package com.acorn.erp.domain.Stock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Stock.Entity.Distribution; // Distribution 엔티티를 임포트
import com.acorn.erp.domain.Stock.Entity.Vendor;
import com.acorn.erp.domain.Stock.Repository.DistributionRepository;


@RestController
//@CrossOrigin(origins = "http://localhost:3000") // http://localhost:3000에서 오는 요청을 허용
@RequestMapping("/api/distribution")
public class DistributionController {
    
    @Autowired // 생성자 주입
    private DistributionRepository distributionRepository; // 변수명 일치화

    @GetMapping
    public List<Distribution> getAllDistribution() {
        return distributionRepository.findAll(); // 호출하여 모든 Distribution 항목을 반환
    }

    @PostMapping
    public Distribution createDistribution(@RequestBody Distribution distribution) { // 메소드 리턴 타입 및 이름 변경
    	try {
            System.out.println("추가 성공");
            return distributionRepository.save(distribution); // 저장 후 반환
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create distribution: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteDistribution(@PathVariable("id") Long id) { //경로에서 id값 추출
        distributionRepository.deleteById(id); //호출하여 해당 ID를 가진 항목을 삭제
    }

    @PutMapping("/{id}")
    public Distribution updateDistribution(@PathVariable("id") Long id, @RequestBody Distribution distribution) {
        distribution.setId(id); // 설정
        return distributionRepository.save(distribution); //저장 후 반환
    }
    
    @GetMapping("/search")
    public List<Distribution> searchDistributions(@RequestParam("searchTerm") String searchTerm) {
        return distributionRepository.findByDistributionCodeContainingIgnoreCaseOrDistributionNameContainingIgnoreCase(searchTerm, searchTerm);
    }
    
  //페이지네이션
    @GetMapping("/listPage")
    public @ResponseBody Page<Distribution> getAllDistributionPage(Model model, Pageable pageable) {
    	Page<Distribution>pages =  distributionRepository.findAll(pageable);
    	System.out.println(pages);
    	return pages;
    }
    
}