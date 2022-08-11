package com.mherman22.KTMInv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mherman22.KTMInv.models.Products;

public interface ProductRepository extends JpaRepository<Products, Long>{

}
