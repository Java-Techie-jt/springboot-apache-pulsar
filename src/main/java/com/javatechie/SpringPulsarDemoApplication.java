package com.javatechie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.pulsar.annotation.EnablePulsar;

@SpringBootApplication
@EnablePulsar
public class SpringPulsarDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPulsarDemoApplication.class, args);
	}

}
