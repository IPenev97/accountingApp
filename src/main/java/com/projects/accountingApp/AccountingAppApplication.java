package com.projects.accountingApp;

import com.projects.accountingApp.repositories.models.Role;
import com.projects.accountingApp.repositories.models.User;
import com.projects.accountingApp.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication()
public class AccountingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountingAppApplication.class, args);
	}



	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));

			userService.saveUser(new User(null, "Ivo", "1234", "test@test", new ArrayList<>()));
			userService.saveUser(new User(null, "Georgi", "1234", "test@test", new ArrayList<>()));
			userService.saveUser(new User(null, "Manager", "1234", "test@test", new ArrayList<>()));

			userService.addRoleToUser("Ivo", "ROLE_ADMIN");
			userService.addRoleToUser("Georgi", "ROLE_USER");
			userService.addRoleToUser("Manager", "ROLE_MANAGER");



		};
	}

}
