package system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BullDozerApplication {

	public static void setupKafka() {

	}
	public static void main(String[] args) {
		SpringApplication.run(BullDozerApplication.class, args);
	}

}
