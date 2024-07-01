package com.acorn.erp.domain.Financial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialService {

    private final FinancialRepository financialRepository;

    @Autowired
    public FinancialService(FinancialRepository financialRepository) {
        this.financialRepository = financialRepository;
    }

    @Transactional
    public Financial saveOrUpdateFinancial(Financial financial) {
        return financialRepository.save(financial);
    }

    @Transactional
    public void deleteFinancial(Long proNo) {
        financialRepository.deleteById(proNo);
    }

    @Transactional(readOnly = true)
    public List<Financial> getAllFinancial() {
        return financialRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Financial> getFinancialById(Long id) {
        return financialRepository.findById(id);
    }
}
