package com.prcomp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.prcomp.dto.CPUDTO;
import com.prcomp.dto.GPUDTO;
import com.prcomp.dto.OSDTO;
import com.prcomp.dto.ProducerDTO;
import com.prcomp.model.CPU;
import com.prcomp.model.GPU;
import com.prcomp.model.OS;
import com.prcomp.service.CPUService;
import com.prcomp.service.GPUService;
import com.prcomp.service.OSService;
import com.prcomp.service.ProducerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CPUService cpuService;

    @Autowired
    private GPUService gpuService;

    @Autowired
    private OSService osService;

    @Autowired
    private ProducerService producerService;

    @GetMapping
    public String getMainPage(Model model) {
        return "admin-page";
    }

    @GetMapping("/cpu")
    public String getCPUMainPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size, Model model) {
        Page<CPU> elementPage = cpuService.getPaginatedElements(page - 1, size);
        model.addAttribute("cpus", elementPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("currentPageI", page + 1);
        model.addAttribute("currentPageD", page - 1);
        model.addAttribute("totalPage", elementPage.getTotalPages());
        model.addAttribute("cpuNumber", cpuService.findAll().size());
        return "cpu-page";
    }

    @GetMapping("/cpu/add")
    public String getCPUAddPage(Model model) {
        CPUDTO cpu = new CPUDTO();
        model.addAttribute("cpu", cpu);
        return "add-cpu";
    }

    @GetMapping("/cpu/change/{id}")
    public String getCPUChangePage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cpu", cpuService.getElementById(id));
        return "add-cpu";
    }

    @GetMapping("/cpu/delete/{id}")
    public String deleteCPU(@PathVariable("id") Integer id) {
        cpuService.deleteById(id);
        return "redirect:/admin/cpu";
    }

    @PostMapping("/cpu/save")
    public String saveCPU(@Valid @ModelAttribute("cpu") CPUDTO cpudto, BindingResult result) {
        if (result.hasErrors()) {
            return "add-cpu";
        }
        cpuService.save(cpudto);
        return "redirect:/admin/cpu";
    }

    @GetMapping("/gpu")
    public String listGPUs(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size, Model model) {
        Page<GPU> elementPage = gpuService.getPaginatedElements(page - 1, size);
        model.addAttribute("gpus", elementPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("currentPageI", page + 1);
        model.addAttribute("currentPageD", page - 1);
        model.addAttribute("totalPage", elementPage.getTotalPages());
        model.addAttribute("gpuNumber", elementPage.getTotalElements());
        return "gpu-page";
    }

    @GetMapping("/gpu/add")
    public String getGPUAddPage(Model model) {
        GPUDTO gpuDTO = new GPUDTO();
        model.addAttribute("gpu", gpuDTO);
        return "add-gpu";
    }

    @GetMapping("/gpu/change/{id}")
    public String getGPUChangePage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("gpu", gpuService.getElementById(id));
        return "add-gpu";
    }

    @GetMapping("/gpu/delete/{id}")
    public String deleteGPU(@PathVariable("id") Integer id) {
        gpuService.deleteById(id);
        return "redirect:/admin/gpu";
    }

    @PostMapping("/gpu/save")
    public String saveGPU(@Valid @ModelAttribute("gpu") GPUDTO gpudto, BindingResult result) {
        if (result.hasErrors()) {
            return "add-gpu";
        }
        gpuService.save(gpudto);
        return "redirect:/admin/gpu";
    }

    @GetMapping("/os")
    public String getOSMainPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size, Model model) {
        Page<OS> elementPage = osService.getPaginatedElements(page - 1, size);
        model.addAttribute("oses", elementPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", elementPage.getTotalPages());
        model.addAttribute("osNumber", osService.findAll().size());
        return "os-page";
    }

    @GetMapping("/os/add")
    public String getOSAddPage(Model model) {
        OSDTO osDTO = new OSDTO();
        model.addAttribute("os", osDTO);
        return "add-os";
    }

    @GetMapping("/os/change/{id}")
    public String getOSChangePage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("os", osService.getElementById(id));
        return "add-os";
    }

    @GetMapping("/os/delete/{id}")
    public String deleteOS(@PathVariable("id") Integer id) {
        osService.deleteById(id);
        return "redirect:/admin/os";
    }

    @PostMapping("/os/save")
    public String saveOS(@Valid @ModelAttribute("os") OSDTO osdto, BindingResult result) {
        if (result.hasErrors()) {
            return "add-os";
        }
        osService.save(osdto);
        return "redirect:/admin/os";
    }

    @GetMapping("/producer")
    public String getProducerMainPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size, Model model) {
        Page<com.prcomp.model.Producer> elementPage = producerService.getPaginatedElements(page - 1, size);
        model.addAttribute("producers", elementPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", elementPage.getTotalPages());
        model.addAttribute("producerNumber", producerService.findAll().size());
        return "producer-page";
    }

    @GetMapping("/producer/add")
    public String getProducerAddPage(Model model) {
        ProducerDTO producerDTO = new ProducerDTO();
        model.addAttribute("producer", producerDTO);
        return "add-producer";
    }

    @GetMapping("/producer/change/{id}")
    public String getProducerChangePage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("producer", producerService.getElementById(id));
        return "add-producer";
    }

    @GetMapping("/producer/delete/{id}")
    public String deleteProducer(@PathVariable("id") Integer id) {
        producerService.deleteById(id);
        return "redirect:/admin/producer";
    }

    @PostMapping("/producer/save")
    public String saveProducer(@Valid @ModelAttribute("producer") ProducerDTO producerdto, BindingResult result) {
        if (result.hasErrors()) {
            return "add-producer";
        }
        producerService.save(producerdto);
        return "redirect:/admin/producer";
    }

}
