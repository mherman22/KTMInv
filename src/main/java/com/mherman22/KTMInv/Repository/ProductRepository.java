package com.mherman22.KTMInv.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mherman22.KTMInv.models.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, UUID> {

}
