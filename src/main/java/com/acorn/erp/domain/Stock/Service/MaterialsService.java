package com.acorn.erp.domain.Stock.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.erp.domain.Stock.Entity.Materials;
import com.acorn.erp.domain.Stock.Repository.MaterialsRepository;

@Service
public class MaterialsService {

    @Autowired
    private MaterialsRepository materialsRepository;

    public List<Materials> getAllMaterials() {
        return materialsRepository.findAll();
    }

    public Materials saveMaterials(Materials materials) {
        return materialsRepository.save(materials);
    }

    public void deleteMaterials(Long id) {
    	materialsRepository.deleteById(id);
    }

    public Materials updateMaterials(Long id, Materials materials) {
    	materials.setId(id);
        return materialsRepository.save(materials);
    }
}