package com.acorn.erp.domain.Financial;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "financial")
public class Financial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_NO")
    private Long proNo;

    @Column(name = "PRO_DSC")
    private String proDsc;

    @Column(name = "PRONM")
    private String pronm;

    @Column(name = "CUSNM")
    private String cusnm;

    @Column(name = "PRO_DTM")
    private LocalDateTime proDtm;

    @Column(name = "PAY_STS")
    private String paySts;

    @Column(name = "PAY")
    private Double pay;

    @Column(name = "UNIT_PAY")
    private Double unitPay;

    @Column(name = "PRO_NUMBER")
    private Integer proNumber;

    @Column(name = "ETC")
    private String etc;

    public Financial() {
    }

    public Financial(Long proNo, String proDsc, String pronm, String cusnm, LocalDateTime proDtm, String paySts, Double pay, Double unitPay, Integer proNumber, String etc) {
        this.proNo = proNo;
        this.proDsc = proDsc;
        this.pronm = pronm;
        this.cusnm = cusnm;
        this.proDtm = proDtm;
        this.paySts = paySts;
        this.pay = pay;
        this.unitPay = unitPay;
        this.proNumber = proNumber;
        this.etc = etc;
    }

    // Getters and setters
    
}
