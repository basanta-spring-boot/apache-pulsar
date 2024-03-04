package com.javatechie;

import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.shade.org.glassfish.jersey.internal.inject.Custom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.pulsar.annotation.EnablePulsar;
import org.springframework.pulsar.core.DefaultSchemaResolver;
import org.springframework.pulsar.core.SchemaResolver;

@SpringBootApplication
@EnablePulsar
public class ApachePulsarDemoApplication {

//	@Bean
//	public SchemaResolver.SchemaResolverCustomizer<DefaultSchemaResolver> schemaResolverCustomizer() {
//		return (schemaResolver) -> {
//			schemaResolver.addCustomSchemaMapping(Custom.class, Schema.JSON(Custom.class));
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(ApachePulsarDemoApplication.class, args);
	}

}
