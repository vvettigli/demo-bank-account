package conto_corrente.conto.A;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import conto_corrente.Dao.userDao;
import conto_corrente.Entity.*;


@SpringBootApplication
@EntityScan("conto_corrente.Entity")   

public class ContoApplication implements CommandLineRunner {

	
	userDao user;

	private static final Logger log = LoggerFactory.getLogger(ContoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ContoApplication.class, args);
		log.info("HELLO");
		
	
	}
	@Override
	public void run(String... args) throws Exception {
		user.save(new user("2314","suca","checco",2000.0));
		
	}

}
