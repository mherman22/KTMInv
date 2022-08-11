package com.mherman22.KTMInv.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentID;
	
	@Column(name = "payment_mode")
	private String paymentMode;
	
	@Column(name = "payment_date")
	private Date paymentDate;

}