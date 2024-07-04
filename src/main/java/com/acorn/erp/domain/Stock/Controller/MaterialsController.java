package com.acorn.erp.domain.Stock.Controller;

import com.acorn.erp.domain.Stock.Entity.Materials;
import com.acorn.erp.domain.Stock.Repository.MaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
public class MaterialsController {

    @Autowired
    private MaterialsRepository materialsRepository;

    @GetMapping
    public List<Materials> getAllMaterials() {
        return materialsRepository.findAll();
    }

    @PostMapping
    public Materials createMaterials(@RequestBody Materials materials) {
        System.out.println("추가 성공");
        return materialsRepository.save(materials);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterials(@PathVariable("id") Long id) {
        materialsRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Materials updateMaterials(@PathVariable("id") Long id, @RequestBody Materials materials) {
        materials.setId(id);
        return materialsRepository.save(materials);
    }

    @GetMapping("/search")
    public List<Materials> searchMaterials(@RequestParam("searchTerm") String searchTerm) {
        return materialsRepository.findByItemCodeContainingIgnoreCaseOrItemNameContainingIgnoreCase(searchTerm, searchTerm);
    }
}