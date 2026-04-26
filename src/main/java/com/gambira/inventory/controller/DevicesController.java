package com.gambira.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gambira.inventory.models.Mdl_devices;
import com.gambira.inventory.repository.Repo_devices;

@Controller
public class DevicesController {

    @Autowired
    private Repo_devices deviceRepo;


    @PostMapping("/devices/save")
    public String saveDevice(Mdl_devices device) {
        deviceRepo.save(device);
        return "redirect:/dashboard";
    }
    @GetMapping("/device/delete")
    public String delete(@RequestParam("id") Long id) {
    	deviceRepo.deleteById(id);
    	return "redirect:/dashboard";
    }
    
    @GetMapping("/device/update")
    public String update(@RequestParam("id") Long id, Model model) {
    	model.addAttribute("devices", deviceRepo.findById(id));
    	return "devices";
    }
}
