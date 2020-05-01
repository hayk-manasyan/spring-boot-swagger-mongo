package com.project.io.demo.repository;

import com.project.io.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMongoRepository extends MongoRepository<User, Long> {
    User findByName(String name);
}
