package com.mherman22.KTMInv.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerID;

	@Column(name = "first_name")
	@NotBlank(message = "First Name cannot be blank")
	@Size(min = 2, max = 20, message = "First Name cannot be more than 20 characters")
	@NameConstraint
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message = "Last Name cannot be blank")
	@Size(min = 2, max = 20, message = "Last Name cannot be more than 20 characters")
	@NameConstraint
	private String lastName;

	@Column(name = "physical_address")
	@NotBlank(message = "Physical Address cannot be blank")
	private String physicalAddress;

	@Column(name = "email_address")
	@NotBlank(message = "Email cannot be blank")
	@Email
	private String emailAddress;

	@Column(name = "phone_number")
	@NotBlank(message = "Phone Number cannot be blank")
	private String phoneNumber;
}
