package br.com.reneg.oslc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding
public class OslcApplication {

	public static void main(String[] args) {
		SpringApplication.run(OslcApplication.class, args);
	}

}
