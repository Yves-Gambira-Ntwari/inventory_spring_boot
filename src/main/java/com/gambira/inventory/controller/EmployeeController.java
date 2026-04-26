package com.gambira.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gambira.inventory.models.Mdl_department;
import com.gambira.inventory.models.Mdl_employee;
import com.gambira.inventory.repository.Repo_department;
import com.gambira.inventory.repository.Repo_employee;

@Controller
public class EmployeeController {
	@Autowired
	Repo_employee repoEmployee;
	@Autowired
	Repo_department repoDepartment;
	@PostMapping("/employee/save")
	public String save(Mdl_employee employee) {
		repoEmployee.save(employee);
		return "redirect:/dashboard";
	}
	@GetMapping("/employee/delete")
	public String delete(@RequestParam("id") Long id) {
		repoEmployee.deleteById(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/employee/update")
	public String update(@RequestParam("id") Long id, Model model) {
		Mdl_employee employee = repoEmployee.findById(id).orElse(null);
		model.addAttribute("employee",employee);
    	List<Mdl_department> department = repoDepartment.findAll();
    	model.addAttribute("department", department);
		return "employee";
	}
}
