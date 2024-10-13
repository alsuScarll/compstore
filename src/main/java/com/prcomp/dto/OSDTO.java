package com.prcomp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OSDTO {

	private Integer id;
	
	@NotEmpty(message = "Please, write OS name")
	@NotNull(message = "Please, write OS name")
	private String name;
	
	@NotEmpty(message = "Please, write OS version")
	@NotNull(message = "Please, write OS version")
	private String version;
	
}
