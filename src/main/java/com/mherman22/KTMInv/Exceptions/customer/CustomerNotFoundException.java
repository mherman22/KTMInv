package com.mherman22.KTMInv.Exceptions.customer;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("customer not found with " + id + " as ID");
    }
}
