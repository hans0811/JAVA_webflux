package com.hans.reactspring.config;

import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.boot.autoconfigure.mongo.ReactiveMongoClientFactory;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveAggregationOperation;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;

/**
 * @author hans
 */
@Profile(value = "local")
@Configuration
@Import(EmbeddedMongoAutoConfiguration.class)
public class DataConfig {

    public static final String DATABASE_NAME = "reservations";

    // MongoClient form EmbeddedMongoAutoConfiguration.class
    @Bean
    public ReactiveMongoDatabaseFactory mongoClientFactory(MongoClient mongoClient) {
        return new SimpleReactiveMongoDatabaseFactory(mongoClient, DATABASE_NAME);
    }

    @Bean
    public ReactiveMongoOperations reactiveMongoTemplate(ReactiveMongoDatabaseFactory mongoDatabaseFactory){
        return new ReactiveMongoTemplate(mongoDatabaseFactory);
    }

}
