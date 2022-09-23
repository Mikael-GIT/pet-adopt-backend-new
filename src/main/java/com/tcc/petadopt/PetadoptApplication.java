package com.tcc.petadopt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import com.tcc.petadopt.domain.Usuario;
import com.tcc.petadopt.repositories.UsuarioRepository;

@SpringBootApplication
@EnableSpringDataWebSupport
public class PetadoptApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetadoptApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(UsuarioRepository repository) {
    return (args) -> {
		Usuario usuario = new Usuario();
		usuario.setNome("Aluno");
		usuario.setEmail("aluno@email.com");
		usuario.setSenha("$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq");
        repository.save(usuario);
		};
	}

}
