package com.prcomp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prcomp.dto.ComputerDTO;
import com.prcomp.model.Computer;
import com.prcomp.repository.ComputerRepository;
import com.prcomp.utility.ConverterUtility;

@Service
public class ComputerService {
    
    @Autowired
    private ComputerRepository computerRepository;
    
    @Autowired
    private ConverterUtility converterUtility;
    
    public List<Computer> findAll() {
        return computerRepository.findAll();
    }
    
    public Page<Computer> getPaginatedElements(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return computerRepository.findAll(pageable);
    }
    
    public Computer save(ComputerDTO computerDto) {
        return computerRepository.save(converterUtility.convertDTOToEntity(computerDto));
    }
    
    public Computer getElementById(Integer id) {
		return computerRepository.getReferenceById(id);
	}
    
    public void deleteById(Integer Id) {
    	computerRepository.deleteById(Id);
    }
    
	
	
}
