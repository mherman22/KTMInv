package com.mherman22.KTMInv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mherman22.KTMInv.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
