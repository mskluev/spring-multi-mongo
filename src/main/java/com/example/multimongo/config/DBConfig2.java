package com.example.multimongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoClientFactory;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClientOptions;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.multimongo.repo2", mongoTemplateRef = "mongoTemplate2")
public class DBConfig2 {

	@Autowired
	private Environment environment;

	@Bean(name = "mongoTemplate2")
	public MongoTemplate mongoTemplate(@Qualifier("mongoFactory2") MongoDbFactory mongoFactory) throws Exception {
		return new MongoTemplate(mongoFactory);
	}

	@Bean("mongoFactory2")
	public MongoDbFactory mongoFactory(@Qualifier("mongoProperties2") MongoProperties mongoProperties)
			throws Exception {
		return new SimpleMongoDbFactory(new MongoClientFactory(mongoProperties, environment)
				.createMongoClient(MongoClientOptions.builder().build()), mongoProperties.getDatabase());
	}

	@Bean(name = "mongoProperties2")
	@ConfigurationProperties(prefix = "mongodb2")
	public MongoProperties properties() throws Exception {
		return new MongoProperties();
	}

}