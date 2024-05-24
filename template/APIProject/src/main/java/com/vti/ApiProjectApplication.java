package com.vti;

import com.vti.repository.AccountRepository;
import com.vti.service.AccountService;
import com.vti.service.impl.AccountServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApiProjectApplication {

	public static void main(String[] args) {
		ApplicationContext application = SpringApplication.run(ApiProjectApplication.class, args);
		// IoC
		// Bean:Object Java
		System.out.println(application.getBean(AccountService.class));
		System.out.println(application.getBean(AccountRepository.class));
	}

}
