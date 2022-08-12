package com.mherman22.KTMInv.payloads.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoResponse {
	
	private Long id;
	private String username;
	private String email;
	private List<String> roles;

}
