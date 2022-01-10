package com.github.lf2a.hrpayroll.service;

import com.github.lf2a.hrpayroll.entities.Payment;
import com.github.lf2a.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h1>PaymentService.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 29/03/2021
 */
@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days) {
        var worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
