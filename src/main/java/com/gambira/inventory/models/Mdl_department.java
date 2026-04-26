package com.gambira.inventory.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Mdl_department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Mdl_employee> employees;
    
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<Mdl_employee> getEmployees() { return employees; }
    public void setEmployees(List<Mdl_employee> employees) { this.employees = employees; }
    
    
}

