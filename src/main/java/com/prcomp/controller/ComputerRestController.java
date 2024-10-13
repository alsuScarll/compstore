package com.prcomp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prcomp.dto.ComputerDTO;
import com.prcomp.service.ComputerService;

@RestController
public class ComputerRestController {

	@Autowired
	private ComputerService computerService;
	
	
	@PostMapping("/computer/save")
	public String saveComputer(@RequestBody ComputerDTO computerDTO) {
		computerService.save(computerDTO);
		return "redirect:/profile/computers";
	}
	
	
}
