package com.employeepayroll.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean
	public ModelMapper getMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
		  .setFieldMatchingEnabled(true)
		  .setFieldAccessLevel( org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
		return modelMapper;
	}
}
