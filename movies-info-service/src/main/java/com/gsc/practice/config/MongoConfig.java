package com.gsc.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@Configuration
public class MongoConfig {
	
	@Bean
	public MongoClient mongoClient() {
		
		MongoCredential creds = MongoCredential.createCredential("GSC", "admin", "12345678".toCharArray());
		final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/gscdemo");
		final MongoClientSettings mongoClientSettings = MongoClientSettings.builder().credential(creds)
				.applyConnectionString(connectionString).build();
		
		return MongoClients.create(mongoClientSettings);
		
	}
	
	@Bean
	public ReactiveMongoTemplate  reactiveMongoTemplate(MongoClient mongoClient) {
		return new ReactiveMongoTemplate (mongoClient, "gscdemo");
	}

}
