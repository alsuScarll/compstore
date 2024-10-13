package com.prcomp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProducerDTO {

	private Integer id;
	
	@NotEmpty(message = "Please, write Producer name")
	@NotNull(message = "Please, write Producer name")
	private String name;
}
