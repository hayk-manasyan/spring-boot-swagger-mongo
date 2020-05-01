package com.project.io.demo.repository;

import com.project.io.demo.domain.User;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMongoRepositoryTest {
    
    @Autowired
    UserMongoRepository userMongoRepository;
    
    
    @Test
    void saveSusscess()
    {

        User user = new User();
        user.setAge(12);
        user.setName("First name");
        user.setCreateDateTime(ZonedDateTime.now(ZoneOffset.UTC));


        user = userMongoRepository.save(user);
        Assertions.assertNotNull(user.getId());
    }
}
