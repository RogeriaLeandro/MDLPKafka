package br.mil.defesa.interc2.mdlp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;


@SpringBootApplication
@EnableKafka
@EnableKafkaStreams
public class MdlpKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdlpKafkaApplication.class, args);
	}

}
