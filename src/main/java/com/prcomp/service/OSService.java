package com.prcomp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prcomp.dto.OSDTO;
import com.prcomp.model.OS;
import com.prcomp.repository.OSRepository;
import com.prcomp.utility.ConverterUtility;

@Service
public class OSService {

	@Autowired
    private OSRepository osRepository;
    
    @Autowired
    private ConverterUtility converterUtility;
    
    public List<OS> findAll() {
        return osRepository.findAll();
    }
    
    public Page<OS> getPaginatedElements(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return osRepository.findAll(pageable);
    }
    
    public OS save(OSDTO osDto) {
        return osRepository.save(converterUtility.convertDTOToEntity(osDto));
    }
    
    public OS getElementById(Integer id) {
		return osRepository.getReferenceById(id);
	}
    
    public void deleteById(Integer Id) {
    	osRepository.deleteById(Id);
    }
}
