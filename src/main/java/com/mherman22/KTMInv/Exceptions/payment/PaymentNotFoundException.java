package com.mherman22.KTMInv.Exceptions.payment;

import java.util.UUID;

public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException(UUID id) {
        super("Payment with id " + id + " was not found");
    }
}
