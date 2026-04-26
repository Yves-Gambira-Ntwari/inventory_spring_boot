package com.gambira.inventory.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gambira.inventory.models.Mdl_assegnment;
import com.gambira.inventory.models.Mdl_auditLog;
import com.gambira.inventory.models.Mdl_department;
import com.gambira.inventory.models.Mdl_devices;
import com.gambira.inventory.models.Mdl_employee;
import com.gambira.inventory.repository.Repo_assegnment;
import com.gambira.inventory.repository.Repo_auditLog;
import com.gambira.inventory.repository.Repo_department;
import com.gambira.inventory.repository.Repo_devices;
import com.gambira.inventory.repository.Repo_employee;


@Controller
public class NavigationController {
	
	@Autowired
	Repo_department repoDepartment;
	@Autowired
	Repo_devices repoDevices;
	@Autowired
	Repo_employee repoEmployee;
	@Autowired
	Repo_assegnment repoAssegnmet;
	@Autowired
	Repo_auditLog repoAuditLog;
	
	
	@Controller
	public class HomeController {

	    @GetMapping("/")
	    public String home() {
	        return "login"; // or login or index (your template name)
	    }
	}

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            // No user in session → redirect to login
            return "redirect:/login";
        } else {
        	model.addAttribute("session", loggedInUser);
        }
    	List<Mdl_devices> device = repoDevices.findAll();
    	List<Mdl_employee> employees = repoEmployee.findAll();
    	
    	
    	List<Mdl_department> department = repoDepartment.findAll();
    	List<Mdl_assegnment> assegnment = repoAssegnmet.findAll();
    	model.addAttribute("employees", employees);
    	model.addAttribute("employeeCount", repoEmployee.count());
    	model.addAttribute("device",device);
    	model.addAttribute("deviceCount",repoDevices.count());
    	
    	model.addAttribute("department", department);
    	model.addAttribute("departmentCount", repoDepartment.count());
    	model.addAttribute("assegnment",assegnment);
    	
    	model.addAttribute("employee", new Mdl_employee());
    	
        return "dashboard";	
    }
    
    @GetMapping("/employee")
    public String employeePage(Model model) {
    	model.addAttribute("employee", new Mdl_employee());
    	List<Mdl_department> department = repoDepartment.findAll();
    	model.addAttribute("department", department);
        return "employee"; // employee.html
    }
    
    @GetMapping("/devices")
    public String devicesPage(Model model) {
    	model.addAttribute("devices", new Mdl_devices());
        return "devices"; // devices.html
    }

    @GetMapping("/department")
    public String departmentPage(Model model) {
    	model.addAttribute("department", new Mdl_department());
        return "department"; // department.html
    }
    @GetMapping("/assegnment")
    public String assegnmentPage(Model model) {
    	List<Mdl_devices> device = repoDevices.findAll();
    	List<Mdl_employee> employee = repoEmployee.findAll();
    	model.addAttribute("employee", employee);
    	model.addAttribute("device",device);
    	model.addAttribute("assegnment", new Mdl_assegnment());
    	return "assegnment";
    }
    
    @GetMapping("/history")
    public String historyPage(Model model) {
    	List<Mdl_auditLog> logs = repoAuditLog.findAll();
    	model.addAttribute("logs", logs);
    	return "history";
    }


}

