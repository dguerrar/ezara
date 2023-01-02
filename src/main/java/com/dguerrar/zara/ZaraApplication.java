package com.dguerrar.zara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@ComponentScan({"com.dguerrar"})
@EntityScan("com.dguerrar.zara.domain")
@EnableJpaRepositories("com.dguerrar.zara.repositories")
@OpenAPIDefinition(info = @Info(title = "eZARA API", version = "1.0", description = "eZARA Information"))
public class ZaraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZaraApplication.class, args);
	}

}
