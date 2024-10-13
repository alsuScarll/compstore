package com.prcomp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prcomp.model.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {

}
