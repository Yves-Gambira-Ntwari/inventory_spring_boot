package com.gambira.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gambira.inventory.models.Mdl_assegnment;
import com.gambira.inventory.models.Mdl_auditLog;
import com.gambira.inventory.models.Mdl_devices;
import com.gambira.inventory.models.Mdl_employee;
import com.gambira.inventory.repository.Repo_assegnment;
import com.gambira.inventory.repository.Repo_auditLog;
import com.gambira.inventory.repository.Repo_devices;
import com.gambira.inventory.repository.Repo_employee;

@Controller
public class AssegnmentController {
	@Autowired
	Repo_assegnment repoAssegnment;
	@Autowired
	Repo_devices repoDevices;
	@Autowired
	Repo_employee repoEmployee;
	@Autowired
	Repo_auditLog repoAuditLog;
	@PostMapping("/assignments/save")
	public String save(Mdl_assegnment assegnment, Mdl_auditLog auditLog) {
		repoAssegnment.save(assegnment);
		auditLog.setAction(assegnment.getStatus());
		auditLog.setTimestamp(java.time.LocalDateTime.now().toString());
		auditLog.setDevice(assegnment.getDevice());
		auditLog.setEmployee(assegnment.getEmployee());
		auditLog.setPerformedBy("System");
		repoAuditLog.save(auditLog);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/assignments/delete")
	public String delete(@RequestParam("id") Long id) {
		repoAssegnment.deleteById(id);
		return"redirect:/dashboard";
	}
	@GetMapping("/assignments/update")
	public String update(@RequestParam("id") Long id, Model model) {
    	List<Mdl_devices> device = repoDevices.findAll();
    	List<Mdl_employee> employee = repoEmployee.findAll();
    	model.addAttribute("employee", employee);
    	model.addAttribute("device",device);
    	model.addAttribute("assegnment", repoAssegnment.findById(id));
    	return "assegnment";
	}
	
}
