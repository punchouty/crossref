package com.racloop.data.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.racloop.data.repositories.mongodb")
public class MongoDbConfig {
}
