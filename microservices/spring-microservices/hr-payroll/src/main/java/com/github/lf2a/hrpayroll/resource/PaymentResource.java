package com.github.lf2a.hrpayroll.resource;

import com.github.lf2a.hrpayroll.entities.Payment;
import com.github.lf2a.hrpayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>PaymentResource.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 29/03/2021
 */
@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long workerId, @PathVariable("days") Integer days) {
        var payment = paymentService.getPayment(workerId, days);

        return ResponseEntity.ok(payment);
    }

        public ResponseEntity<Payment> getPaymentAlternative(@PathVariable("workerId") Long workerId, @PathVariable("days") Integer days) {
            var payment = new Payment("Brann", 400.0, days);

            return ResponseEntity.ok(payment);
        }

}
