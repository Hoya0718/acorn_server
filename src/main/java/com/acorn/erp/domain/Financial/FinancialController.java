package com.acorn.erp.domain.Financial;

import com.acorn.erp.domain.Financial.Financial;
import com.acorn.erp.domain.Financial.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/financials")
public class FinancialController {

    @Autowired
    private FinancialService financialService;

    @GetMapping("a")
    public List<Financial> getAllFinancial() {
        return financialService.getAllFinancial();
    }

    @GetMapping("/{id}")
    public Optional<Financial> getFinancialById(@PathVariable("id") Long id) {
        return financialService.getFinancialById(id);
    }

    @PostMapping
    public Financial createFinancial(@RequestBody Financial financial) {
        return financialService.saveOrUpdateFinancial(financial);
    }

    @PutMapping("/{id}")
    public Financial updateFinancial(@PathVariable("id") Long id, @RequestBody Financial financial) {
        financial.setProNo(id);
        return financialService.saveOrUpdateFinancial(financial);
    }

    @DeleteMapping("/{id}")
    public void deleteFinancial(@PathVariable("id") Long id) {
        financialService.deleteFinancial(id);
    }
}
