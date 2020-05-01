package com.project.io.demo.resources;

import com.project.io.demo.domain.User;
import com.project.io.demo.repository.UserMongoRepository;
import com.project.io.demo.service.UserService;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserResource {
    
    @Autowired
    UserService userService;
    
    @PostMapping("/")
    public ResponseEntity<?> createUser(@Valid User user)
    {
        
        user = this.userService.createUser(user);
        
        return ResponseEntity.ok().body(user);
    }
}
