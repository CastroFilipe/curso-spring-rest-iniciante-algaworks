package com.filipe.osworks.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
 * Classe para configurar um Bean para ser injetado pelo spring em objetos ModelMapper marcados com @Autowired.
 * Essa configuração é necessária pois o ModelMapper é uma biblioteca externa e não temos acesso ao código fonte 
 * para colocar alguma anotação como @Service, @Component na classe ModelMapper.
 * */
@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
