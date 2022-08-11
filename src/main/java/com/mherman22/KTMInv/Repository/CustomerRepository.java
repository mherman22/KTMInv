package com.mherman22.KTMInv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mherman22.KTMInv.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
