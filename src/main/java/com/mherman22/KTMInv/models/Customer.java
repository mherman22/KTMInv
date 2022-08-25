package com.mherman22.KTMInv.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
public class Customer implements Serializable {

	@Id
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "id", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID customerID;

	@Column(name = "first_name")
	@NotBlank
	@Size(min = 2, max = 20, message = "First Name cannot be more than 20 characters")
	@NameConstraint
	private String firstName;

	@Column(name = "last_name")
	@NotBlank
	@Size(min = 2, max = 20, message = "Last Name cannot be more than 20 characters")
	@NameConstraint
	private String lastName;

	@Column(name = "physical_address")
	@NotBlank
	private String physicalAddress;

	@Column(name = "email_address")
	@NotBlank
	@Email
	private String emailAddress;

	@Column(name = "phone_number")
	@NotBlank
	private String phoneNumber;
}
