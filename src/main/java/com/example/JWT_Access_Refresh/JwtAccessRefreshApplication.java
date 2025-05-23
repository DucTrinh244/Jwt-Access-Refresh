package com.example.JWT_Access_Refresh;

import com.example.JWT_Access_Refresh.domain.Role;
import com.example.JWT_Access_Refresh.domain.User;
import com.example.JWT_Access_Refresh.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class JwtAccessRefreshApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtAccessRefreshApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "DUC TRINH", "ductrinh", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "KIM OANH", "kimoanh", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "TO TRINH", "totrinh", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "TRA MY", "tramy", "1234", new ArrayList<>()));


			userService.addRoleToUser("ductrinh", "ROLE_USER");
			userService.addRoleToUser("ductrinh", "ROLE_MANAGER");
			userService.addRoleToUser("kimoanh", "ROLE_MANAGER");
			userService.addRoleToUser("totrinh", "ROLE_ADMIN");
			userService.addRoleToUser("tramy", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("tramy", "ROLE_ADMIN");
			userService.addRoleToUser("tramy", "ROLE_USER");
			userService.addRoleToUser("tramy", "ROLE_MANAGER");
			userService.addRoleToUser("tramy", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("tramy", "ROLE_USER");


		};
	}
}
