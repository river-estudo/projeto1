package natan.io.projeto1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import natan.io.projeto1.entity.User;
import natan.io.projeto1.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//System.out.print("\n\n Entrou aqui \n\n");
		
		
		List<User> users =  userRepository.findAll();
		
		if(users.isEmpty()) {		
			createUser("Joao", "joao@email.com");
			createUser("Maria", "maria@email.com");
			createUser("Jose", "jose@email.com");	
		}		
	
		
		User user = userRepository.findByNameIgnoreCaseLike("mar");
		
		System.out.println(user.getName());	
		
		user = userRepository.findByEmailQualquerCoisa("joao@email.com");
		
		System.out.println(user.getName());	
	}
	
	public void createUser(String name, String email) {
		User user = new User(name, email);
		userRepository.save(user);	
	}



}
