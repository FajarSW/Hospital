package com.hmsapp.hospitalmanagement.doclogin.enity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "drug_name")
    private String drugName;

    private String stock;

    public Medicine(){
    }

    public Medicine(long id, String drugName, String stock) {
        super();
        this.id = id;
        this.drugName = drugName;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
