package config;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentApplication implements CommandLineRunner{
	private static Logger LOG = LoggerFactory.getLogger(StudentApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("***** Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			//ctx.getBean
			System.out.println("+++++ count: " + beanNames.length);
			for (int i = 0; i < beanNames.length; i++) {
				System.out.println(i + 1 + ") " + beanNames[i]);

			}
			//Arrays.stream(beanNames).forEach(System.out::println);
		};
	}

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");
		for (int i = 0; i < args.length; ++i) {
			LOG.info("args[{}]: {}", i, args[i]);
		}
		simplePostRequest();
	}

	void simplePostRequest() {
		/*
		// request url
		String url = "https://reqres.in/api/users";

		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// request body parameters
		Map<String, String> map = new HashMap<>();
		map.put("name", "John Doe");
		map.put("job", "Java Developer");

		// send POST request
		ResponseEntity<Void> response = restTemplate.postForEntity(url, map, Void.class);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println("Request Successful");
		} else {
			System.out.println("Request Failed");
		}

		 */
	}
}
