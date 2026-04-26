package com.gambira.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gambira.inventory.models.Mdl_department;
import com.gambira.inventory.repository.Repo_department;

@Controller
public class DepartmentController {

    @Autowired
    private Repo_department deptRepo;

    @PostMapping("/department/save")
    public String saveDepartment(Mdl_department department) {
        deptRepo.save(department);
        return "redirect:/dashboard";
    }
    
    @GetMapping("/departments/delete")
    public String delete(@RequestParam("id") Long id) {
    	deptRepo.deleteById(id);
    	return "redirect:/dashboard";
    }
    @GetMapping("departments/update")
    public String update(@RequestParam("id") Long id, Model model) {
    	model.addAttribute("department", deptRepo.findById(id));
        return "department";
    }
}
