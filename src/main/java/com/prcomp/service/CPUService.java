

package com.prcomp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prcomp.dto.CPUDTO;
import com.prcomp.model.CPU;
import com.prcomp.repository.CPURepository;
import com.prcomp.utility.ConverterUtility;

import java.util.List;
import java.util.Optional;

@Service
public class CPUService {


    @Autowired
    private CPURepository cpuRepository;
    
    @Autowired
    private ConverterUtility converterUtility;
    
    public List<CPU> findAll() {
        return cpuRepository.findAll();
    }
    
    public Page<CPU> getPaginatedElements(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return cpuRepository.findAll(pageable);
    }
    
    public CPU save(CPUDTO cpuDto) {
        return cpuRepository.save(converterUtility.convertDTOToEntity(cpuDto));
    }
    
    public CPU getElementById(Integer id) {
		return cpuRepository.getReferenceById(id);
	}
    
    public void deleteById(Integer Id) {
    	cpuRepository.deleteById(Id);
    }
}
