package com.prcomp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prcomp.model.CPU;
import com.prcomp.model.GPU;

public interface GPURepository extends JpaRepository<GPU, Integer> {


	Page<GPU> findAll(Pageable pageable);
}
