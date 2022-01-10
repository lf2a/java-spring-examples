package com.github.lf2a.hruser.resources;

import com.github.lf2a.hruser.entities.User;
import com.github.lf2a.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>UserResource.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 05/04/2021
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        var user = userRepository.findById(id).get();

        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam("email") String email) {
        var user = userRepository.findByEmail(email);

        return ResponseEntity.ok(user);
    }
}

