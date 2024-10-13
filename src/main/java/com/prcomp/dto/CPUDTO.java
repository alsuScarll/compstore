package com.prcomp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CPUDTO {

	private Integer id;
	
	@NotEmpty(message = "Please, write CPU name")
	@NotNull(message = "Please, write CPU name")
	private String name;
	
	@NotEmpty(message = "Please, write CPU generation")
	@NotNull(message = "Please, write CPU generation")
	private String gen;
	
	@NotNull(message = "Please, write CPU power")
	@Min(value = 500, message = "What a shit CPU you have")
	@Max(value = 1000000, message = "Too Many!")
	private Integer power;
	
	@NotNull(message = "Please, write CPU core")
	@Min(value = 2, message = "Too Little!")
	@Max(value = 20, message = "Too Many!")
	private Integer core;
	
}
