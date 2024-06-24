package bojalar.poputi.poputi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PoputiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoputiApplication.class, args);
	}

}
