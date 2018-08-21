package xyz.ucwork.future;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FutureApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutureApplication.class, args);
	}

	@RequestMapping("/")
	public String function() {
		return "HelloWorld";
	}
}
