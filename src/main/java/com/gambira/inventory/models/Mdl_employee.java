package com.gambira.inventory.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import net.bytebuddy.implementation.bind.annotation.AllArguments.Assignment;

@Entity
public class Mdl_employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    
    @ManyToOne
    @JoinColumn(name = "department", nullable = false)
    Mdl_department department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Mdl_assegnment> assignments;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Mdl_department getDepartment() {
        return department;
    }

    public void setDepartment(Mdl_department department) {
        this.department = department;
    }

    public List<Mdl_assegnment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Mdl_assegnment> assignments) {
        this.assignments = assignments;
    }
}
