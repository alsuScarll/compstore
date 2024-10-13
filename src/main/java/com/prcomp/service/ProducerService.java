package com.prcomp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prcomp.dto.CPUDTO;
import com.prcomp.dto.ProducerDTO;
import com.prcomp.model.CPU;
import com.prcomp.model.Producer;
import com.prcomp.repository.CPURepository;
import com.prcomp.repository.ProducerRepository;
import com.prcomp.utility.ConverterUtility;

@Service
public class ProducerService {

	@Autowired
	private ProducerRepository producerRepository;
    
    @Autowired
    private ConverterUtility converterUtility;
    
    public List<Producer> findAll() {
        return producerRepository.findAll();
    }
    
    public Page<Producer> getPaginatedElements(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return producerRepository.findAll(pageable);
    }
    
    public Producer save(ProducerDTO producerDto) {
        return producerRepository.save(converterUtility.convertDTOToEntity(producerDto));
    }
    
    public Producer getElementById(Integer id) {
		return producerRepository.getReferenceById(id);
	}
    
    public void deleteById(Integer Id) {
    	producerRepository.deleteById(Id);
    }
}
