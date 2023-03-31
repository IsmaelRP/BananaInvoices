package es.netmind.banana_invoices_authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
public class BananaAuthorizationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BananaAuthorizationServerApplication.class, args);
	}
}
