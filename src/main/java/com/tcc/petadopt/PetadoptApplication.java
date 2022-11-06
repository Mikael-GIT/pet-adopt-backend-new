package com.tcc.petadopt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import com.tcc.petadopt.domain.Animal;
import com.tcc.petadopt.domain.Categoria;
import com.tcc.petadopt.repositories.CategoriaRepository;


@SpringBootApplication
@EnableSpringDataWebSupport
public class PetadoptApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetadoptApplication.class, args);
	}


 	@Bean
	public CommandLineRunner loadData(CategoriaRepository categoriaRepository) {
    return (args) -> {
		/*Usuario usuario = new Usuario();
		usuario.setNome("Aluno");
		usuario.setEmail("aluno@email.com");
		usuario.setSenha("$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq");
        repository.save(usuario);
		};
		*/

		Categoria categoria = new Categoria();
		List<Animal> animais = new ArrayList<>();
		Animal animal = new Animal();
		animal.setCor("Preto");
		animal.setIdade("2 meses");
		animal.setNome("Spyke");
		animal.setDescricao("LOREM IPSUM");
		animais.add(animal);
		categoria.setAnimais(animais);
		categoriaRepository.save(categoria);
		};
	}
}
