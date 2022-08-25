package com.mherman22.KTMInv.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mherman22.KTMInv.Exceptions.payment.PaymentNotFoundException;
import com.mherman22.KTMInv.Repository.PaymentRepository;
import com.mherman22.KTMInv.models.Payment;

@RestController
@RequestMapping("/ktm/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/all-payments")
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/{id}")
    Payment getPaymentById(@PathVariable UUID id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
    }

}