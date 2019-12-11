package br.com.reneg.jornada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding
public class JornadaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JornadaApplication.class, args);
	}

}
