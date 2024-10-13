package com.prcomp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.prcomp.dto.ComputerDTO;
import com.prcomp.model.Computer;
import com.prcomp.service.CPUService;
import com.prcomp.service.ComputerService;
import com.prcomp.service.GPUService;
import com.prcomp.service.OSService;
import com.prcomp.service.ProducerService;

@Controller
public class ComputerController {
	
	    @Autowired
	    private ComputerService computerService;
	
	    @Autowired
	    private CPUService cpuService;

	    @Autowired
	    private GPUService gpuService;

	    @Autowired
	    private OSService osService;

	    @Autowired
	    private ProducerService producerService;

	
	@GetMapping("/main")
	public String getMainPage() {
		return "index";
	}
	
	@GetMapping("/profile/computers")
	public String getMyComputersPage(Model model) {
		ComputerDTO computer = new ComputerDTO();
		model.addAttribute("computer", computer);
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("cpus", cpuService.findAll());
		model.addAttribute("oses", osService.findAll());
		model.addAttribute("gpus", gpuService.findAll());
		return "my-computers";
	}
	
}
