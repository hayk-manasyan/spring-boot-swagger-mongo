package com.project.io.demo.service;

import com.project.io.demo.domain.User;
import com.project.io.demo.repository.UserMongoRepository;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMongoRepository userMongoRepository;

    @Override
    public User createUser(User user) {

        user.setCreateDateTime(ZonedDateTime.now(ZoneOffset.UTC));

        return this.userMongoRepository.save(user);
    }

}
