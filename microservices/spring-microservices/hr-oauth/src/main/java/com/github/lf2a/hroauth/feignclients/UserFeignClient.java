package com.github.lf2a.hroauth.feignclients;

import com.github.lf2a.hroauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <h1>UserFeignClient.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 08/04/2021
 */
@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {

    @GetMapping(value = "/search")
    ResponseEntity<User> findByEmail(@RequestParam("email") String email);

}
