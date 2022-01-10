package com.github.lf2a.hroauth.service;

import com.github.lf2a.hroauth.entities.User;
import com.github.lf2a.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * <h1>UserService.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 08/04/2021
 */
@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        var user = userFeignClient.findByEmail(email).getBody();

        if (user == null) {
            logger.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }

        logger.info("Email found: " + email);

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var user = userFeignClient.findByEmail(s).getBody();

        if (user == null) {
            logger.error("Email not found: " + s);
            throw new UsernameNotFoundException("Email not found");
        }

        logger.info("Email found: " + s);

        return user;
    }
}
