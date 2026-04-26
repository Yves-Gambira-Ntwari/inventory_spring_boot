package com.gambira.inventory.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mdl_auditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action; // Issued, Returned, Updated
    private String timestamp;
    private String performedBy;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Mdl_devices device;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Mdl_employee employee;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    public Mdl_devices getDevice() {
        return device;
    }

    public void setDevice(Mdl_devices device) {
        this.device = device;
    }

    public Mdl_employee getEmployee() {
        return employee;
    }

    public void setEmployee(Mdl_employee employee) {
        this.employee = employee;
    }
}

