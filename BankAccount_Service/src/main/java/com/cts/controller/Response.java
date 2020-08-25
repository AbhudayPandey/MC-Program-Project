package com.cts.controller;
import java.util.List;

import com.cts.model.AccountDetails;
public class Response {
	public String message;
	public List<AccountDetails> lst;
	

	
	
	public List<AccountDetails> getLst() {
		return lst;
	}

	public void setLst(List<AccountDetails> lst) {
		this.lst = lst;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
