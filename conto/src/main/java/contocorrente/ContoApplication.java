package contocorrente;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import contocorrente.dao.UserRepository;
import contocorrente.entities.*;


@SpringBootApplication(
	/*scanBasePackages = "contocorrente"*/)
//@EntityScan("contocorrente")   
public class ContoApplication implements CommandLineRunner {



    @Autowired
	UserRepository userRepository;

	private static final Logger log = LoggerFactory.getLogger(ContoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ContoApplication.class, args);
		log.info("HELLO");
		
	
	}
	@Override
	public void run(String... args) throws Exception {
		User user = new User("2314","suca","checco");
		userRepository.save (user);
		
	}

}
