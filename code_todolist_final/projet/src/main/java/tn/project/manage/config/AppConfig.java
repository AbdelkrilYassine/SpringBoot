package tn.project.manage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.xebia.extras.selma.Selma;
import tn.project.manage.dto.TaskMapper;

@Configuration
public class AppConfig {

	@Bean
	TaskMapper taskMapper() {
		return Selma.builder(TaskMapper.class).build();
	}
}

