package com.mherman22.KTMInv.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mherman22.KTMInv.Repository.CustomerRepository;
import com.mherman22.KTMInv.models.Customer;

@RestController
@RequestMapping("/ktm/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * gets all customers
     * 
     * @return List<Customer>
     */
    @GetMapping(value = "/list")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    /**
     * gets customer details by customerid
     * 
     * @param id
     * @return Object
     */
    @GetMapping("/{id}")
    public Object getCustomerById(@PathVariable Long id) {

        HashMap<String, Object> response = new HashMap<>();
        response.put("error", "Customer with id-- " + id + " -- not found!");

        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            return customer.get();
        } else {
            return response;
        }
    }

    /**
     * creates new customer
     * 
     * @param newCustomer
     * @param result
     * @return Object
     */
    @PostMapping(value = "/create")
    public Object createCustomer(@Valid @RequestBody Customer newCustomer, BindingResult result) {

        if (result.hasErrors()) {
            return result.getAllErrors();
        }

        Customer createdCustomer = customerRepository.save(newCustomer);

        return createdCustomer;
    }

    /**
     * updates a customer's details
     * 
     * @param updatecustomer
     * @return
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCustomer(@Valid @RequestBody Customer updatecustomer, BindingResult result) {

        // Customer customer =
        // customerRepository.getOne(updatecustomer.getCustomerID());
        // customer = updatecustomer;

        if (result.hasErrors()) {
            return (ResponseEntity<?>) result.getAllErrors();
        }
        customerRepository.save(updatecustomer);
        return ResponseEntity.ok("customer has been updated");
    }

    /**
     * deletes a customer using the id
     * 
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }

}
