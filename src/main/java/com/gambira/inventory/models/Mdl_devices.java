package com.gambira.inventory.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.bytebuddy.implementation.bind.annotation.AllArguments.Assignment;

@Entity
@Table(name="devices")
public class Mdl_devices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String type; // Laptop/Desktop/Mobile
    private String brand;
    private String model;
    private String specifications;
    private String conditions;
    private String status; // Available/Issued/Returned

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<Mdl_assegnment> assignments;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<Mdl_auditLog> auditLogs;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getSpecifications() { return specifications; }
    public void setSpecifications(String specifications) { this.specifications = specifications; }

    public String getConditions() { return conditions; }
    public void setConditions(String condition) { this.conditions = condition; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

