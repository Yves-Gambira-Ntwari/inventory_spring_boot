package com.gambira.inventory.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mdl_assegnment {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String issueDate;
	    private String returnDate;
	    private String status;

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

	    public String getIssueDate() {
	        return issueDate;
	    }

	    public void setIssueDate(String issueDate) {
	        this.issueDate = issueDate;
	    }

	    public String getReturnDate() {
	        return returnDate;
	    }

	    public void setReturnDate(String returnDate) {
	        this.returnDate = returnDate;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
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

