package com.mherman22.KTMInv.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import com.mherman22.KTMInv.Validations.NameConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

	@Id
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "paymentid", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID paymentID;

	@Column(name = "payment_mode")
	@NotBlank
	@NameConstraint
	private String paymentMode;

	@Column(name = "payment_date")
	@NotBlank
	private Date paymentDate;
}
