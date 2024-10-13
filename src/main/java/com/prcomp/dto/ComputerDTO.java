package com.prcomp.dto;

import com.prcomp.model.CPU;
import com.prcomp.model.GPU;
import com.prcomp.model.OS;
import com.prcomp.model.Producer;

import lombok.Data;


@Data
public class ComputerDTO {

	private Integer id;
	private String name;
	private ProducerDTO producer;
	private String state;
	private Double price;
	private String description;
	private Integer ram;
	private CPUDTO cpu;
	private Integer rom;
	private String romType;
	private OSDTO os;
	private GPUDTO gpu;
	private String imgURL;
}
