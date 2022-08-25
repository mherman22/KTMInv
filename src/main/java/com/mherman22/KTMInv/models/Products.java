package com.mherman22.KTMInv.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.mherman22.KTMInv.Validations.NameConstraint;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products implements Serializable {

	@Id
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "productid", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID productID;

	@Column(name = "product_name")
	@NotBlank
	@Size(min = 2, max = 20, message = "Product Name cannot be more than 20 characters")
	@NameConstraint
	private String productName;

	@Column(name = "product_type")
	@NotBlank
	private String productType;

	@Column(name = "product_description")
	@NotBlank
	private String productDescription;

	@Column(name = "product_quantity")
	@NotBlank
	private Integer productQuantity;
}
