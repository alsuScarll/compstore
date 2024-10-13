

package com.prcomp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prcomp.dto.GPUDTO;
import com.prcomp.model.GPU;
import com.prcomp.repository.GPURepository;
import com.prcomp.utility.ConverterUtility;

@Service
public class GPUService {

	@Autowired
    private GPURepository gpuRepository;
    
    @Autowired
    private ConverterUtility converterUtility;
    
    public List<GPU> findAll() {
        return gpuRepository.findAll();
    }
    
    public Page<GPU> getPaginatedElements(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return gpuRepository.findAll(pageable);
    }
    
    public GPU save(GPUDTO gpuDto) {
        return gpuRepository.save(converterUtility.convertDTOToEntity(gpuDto));
    }
    
    public GPU getElementById(Integer id) {
		return gpuRepository.getReferenceById(id);
	}
    
    public void deleteById(Integer Id) {
    	gpuRepository.deleteById(Id);
    }
}


