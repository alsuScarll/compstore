package com.prcomp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prcomp.model.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {

}
