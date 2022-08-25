package com.mherman22.KTMInv.Exceptions.product;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("product with id " + id + " was not found");
    }

}
