package com.example.multimongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoClientFactory;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClientOptions;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.multimongo.repo1", mongoTemplateRef = "mongoTemplate1")
public class DBConfig1 {

	@Autowired
	private Environment environment;

	@Primary
	@Bean(name = "mongoTemplate1")
	public MongoTemplate mongoTemplate(@Qualifier("mongoFactory1") MongoDbFactory mongoFactory) throws Exception {
		return new MongoTemplate(mongoFactory);
	}

	@Primary
	@Bean("mongoFactory1")
	public MongoDbFactory mongoFactory(@Qualifier("mongoProperties1") MongoProperties mongoProperties)
			throws Exception {
		return new SimpleMongoDbFactory(new MongoClientFactory(mongoProperties, environment)
				.createMongoClient(MongoClientOptions.builder().build()), mongoProperties.getDatabase());
	}

	@Bean(name = "mongoProperties1")
	@ConfigurationProperties(prefix = "mongodb1")
	@Primary
	public MongoProperties properties() throws Exception {
		return new MongoProperties();
	}

}