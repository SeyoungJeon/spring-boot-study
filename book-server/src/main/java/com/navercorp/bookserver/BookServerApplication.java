package com.navercorp.bookserver;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.zalando.problem.ProblemModule;

@SpringBootApplication
public class BookServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookServerApplication.class, args);
	}

	@Bean
	public Module jdk8Module() {
		return new Jdk8Module();
	}

	@Bean
	public Module problemModule() {
		return new ProblemModule();
	}
}