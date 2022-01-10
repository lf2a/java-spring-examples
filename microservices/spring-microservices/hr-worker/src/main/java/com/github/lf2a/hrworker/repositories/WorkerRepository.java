package com.github.lf2a.hrworker.repositories;

import com.github.lf2a.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>WorkerRepository.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 29/03/2021
 */
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
