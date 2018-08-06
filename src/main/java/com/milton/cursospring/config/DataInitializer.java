package com.milton.cursospring.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.milton.cursospring.entity.User;
import com.milton.cursospring.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;

	public void onApplicationEvent(ContextRefreshedEvent event) {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {

			createUser("Milton", "miltonabdon69@gmail.com");
			createUser("Johnny", "johnny@gmail.com");
			createUser("Tang", "tang@gmail.com");

		}

		
		//Deletar Usuário através do ID.
		// userRepository.deleteById(2L);
		

		//Buscando por método mágico Name
		User buscaPorNome = userRepository.findByName("Johnny");
		System.out.println("Busca por Name: " + buscaPorNome.getName() + " e Email: " + buscaPorNome.getEmail());
		
//		Buscando por método mágico Email
//		User buscaPorEmail = userRepository.findByEmail("tang@gmail.com");
//		System.out.println("Busca por Email: " + buscaPorEmail.getName());
		
		//Buscando no nome independente de Case
		User findByNameIgnoreCase = userRepository.findByNameIgnoreCaseLike("milt");
		System.out.println(findByNameIgnoreCase.getName());
		
		User findByEmailProprio = userRepository.findByEmailProprio("tang@gmail.com");
		System.out.println("Teste email proprio: " + findByEmailProprio);

	}

	public void createUser(String name, String email) {

		User user = new User(name, email);

		userRepository.save(user);

	}

}
