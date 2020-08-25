package com.cts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@NonNull
@Entity
public @Data class AccountDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Long pan;
	private Long accountnumber;
	private String ifsccode;
	private String bankname;
	private Long  micrcode;
	
	
	
}
