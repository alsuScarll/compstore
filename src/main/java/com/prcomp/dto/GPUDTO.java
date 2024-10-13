package com.prcomp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GPUDTO {

	private Integer id;
	
	@NotEmpty(message = "Please, write GPU name")
	@NotNull(message = "Please, write GPU name")
	private String name;
	
	@NotEmpty(message = "Please, write GPU prototype")
	@NotNull(message = "Please, write GPU prototype")
	private String prototype;
	
	
	@NotNull(message = "Please, write GPU memory")
	@Min(value = 6, message = "Too Little!")
	@Max(value = 128, message = "Too Many!")
	private Integer memory;
	
}
