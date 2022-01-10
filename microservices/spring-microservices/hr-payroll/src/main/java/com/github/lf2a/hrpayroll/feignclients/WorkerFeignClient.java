package com.github.lf2a.hrpayroll.feignclients;

import com.github.lf2a.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <h1>WorkerFeignClient.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 29/03/2021
 */
@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Worker> findById(@PathVariable("id") Long id);
}
