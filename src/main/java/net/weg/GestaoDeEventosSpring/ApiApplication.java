package net.weg.GestaoDeEventosSpring;

import net.weg.GestaoDeEventosSpring.Repository.EventoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		EventoRepository bancoEvento ;
		//bancoEvento.findAll();
	}
}
