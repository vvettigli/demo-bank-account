package contocorrente;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
	/*scanBasePackages = "contocorrente"*/)
//@EntityScan("contocorrente")   
public class ContoApplication implements CommandLineRunner {



    private static final Logger log = LoggerFactory.getLogger(ContoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ContoApplication.class, args);
		log.info("HELLO");
		
	
	}
	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
