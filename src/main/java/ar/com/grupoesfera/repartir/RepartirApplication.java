package ar.com.grupoesfera.repartir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class RepartirApplication {

	public static void main(String[] args) {

		SpringApplication.run(RepartirApplication.class, args);
	}

}
