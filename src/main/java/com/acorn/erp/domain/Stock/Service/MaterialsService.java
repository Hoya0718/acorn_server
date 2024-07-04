package com.acorn.erp.domain.Stock.Service;

import com.acorn.erp.domain.Stock.Entity.Distribution;
import com.acorn.erp.domain.Stock.Entity.Materials;
import com.acorn.erp.domain.Stock.Repository.MaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void deleteMaterials(String itemCode) {
        materialsRepository.deleteById(itemCode);
    }

    public Materials updateMaterials(String itemCode, Materials materials) {
        materials.setItemCode(itemCode);
        return materialsRepository.save(materials);
    }

    public Materials saveDistributionAsMaterials(Distribution distribution) {
        Materials materials = new Materials();
        materials.setItemCode(distribution.getItemCode()); // 주 키 설정
        materials.setItemName(distribution.getItemName()); // FK
        materials.setReceiptDate(distribution.getReceiptDate()); // FK
        // 나머지 필드들도 필요에 따라 매핑 추가

        return materialsRepository.save(materials);
    }
}