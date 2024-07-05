package com.acorn.erp.domain.Stock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Stock.Entity.Materials;
import com.acorn.erp.domain.Stock.Repository.MaterialsRepository;


@RestController
//@CrossOrigin(origins = "http://localhost:3000") // http://localhost:3000에서 오는 요청을 허용
@RequestMapping("/api/materials")
public class MaterialsController {
    
    @Autowired // 생성자 주입
    private MaterialsRepository materialsRepository; // 변수명 일치화

    @GetMapping
    public List<Materials> getAllMaterials() {
        return materialsRepository.findAll(); // 호출하여 모든 Distribution 항목을 반환
    }

    @PostMapping
    public Materials createMaterials(@RequestBody Materials materials) { // 메소드 리턴 타입 및 이름 변경
    	try {
            System.out.println("추가 성공");
            return materialsRepository.save(materials); // 저장 후 반환
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create materials: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMaterials(@PathVariable("id") Long id) { //경로에서 id값 추출
    	materialsRepository.deleteById(id); //호출하여 해당 ID를 가진 항목을 삭제
    }

    @PutMapping("/{id}")
    public Materials updateMaterials(@PathVariable("id") Long id, @RequestBody Materials materials) {
    	materials.setId(id); // 설정
        return materialsRepository.save(materials); //저장 후 반환
    }
    
    @GetMapping("/search")
    public List<Materials> searchMaterials(@RequestParam("searchTerm") String searchTerm) {
        return materialsRepository.findByMaterialsCodeContainingIgnoreCaseOrMaterialsNameContainingIgnoreCase(searchTerm, searchTerm);
    }
    
}