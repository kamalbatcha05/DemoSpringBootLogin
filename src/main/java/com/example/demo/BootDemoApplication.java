package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class BootDemoApplication {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}

	@PostConstruct
	public void setupDbWithData(){
//		User user= new User();
//		user.setName("Kamal");
//		user.setLastName("Batcha");
//		user.setEmail("test@gmail.com");
//		user.setPassword(bCryptPasswordEncoder.encode("password"));
//        user.setActive(true);
//        Role role = new Role();
//        role.setRole("ADMIN");
//        Role userRole = roleRepository.save(role);
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//		
//		user= userRepository.save(user);
	}
}
