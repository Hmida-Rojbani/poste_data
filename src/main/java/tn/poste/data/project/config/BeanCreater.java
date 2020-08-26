package tn.poste.data.project.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCreater {
	
	@Bean
	public ModelMapper getMapper() {
		ModelMapper modelMapper= new ModelMapper();
		modelMapper.getConfiguration()
		  .setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

}
