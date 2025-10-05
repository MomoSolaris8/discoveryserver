package com.momoio.discoveryserver;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
@EnableEurekaServer
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//	public CommandLineRunner startup(BCryptPasswordEncoder encoder) {
//		return args -> {
//			var password = encoder.encode("letMeinMomo");
//			System.out.println(password); //$2a$12$SJu0iYfBaZeSk91hGj9m3OBbTDG5FPbNk36kVaG7MuzpDjoub0T2S
//		};
//
//	}
}
