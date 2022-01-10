package com.github.lf2a.hrworker.resources;

import com.github.lf2a.hrworker.entities.Worker;
import com.github.lf2a.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h1>WorkerResource.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 29/03/2021
 */
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        var workerList = workerRepository.findAll();

        return ResponseEntity.ok(workerList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable("id") Long id) {
        var worker = workerRepository.findById(id).get();

        return ResponseEntity.ok(worker);
    }
}
