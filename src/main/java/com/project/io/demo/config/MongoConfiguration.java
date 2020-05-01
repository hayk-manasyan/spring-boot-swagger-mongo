package com.project.io.demo.config;

import com.project.io.demo.converter.ZonedDateTimeJsonDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.project.io.demo.converter.ZonedDateTimeJsonSerializer;

import java.util.Arrays;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfiguration {

    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoDbFactory mongoDbFactory, MongoMappingContext mongoMappingContext) {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
        converter.setCustomConversions(customConversions());
        return converter;
    }

    private CustomConversions customConversions() {
        return new CustomConversions(Arrays.asList(
                new ZonedDateTimeJsonDeserializer(),
                new ZonedDateTimeJsonSerializer()
        ));
    }
}
