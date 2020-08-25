package com.cts.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.AccountDetails;
import com.cts.repository.AccountDetailsRepository;
import com.cts.service.AccountDetailsService;


@RestController
public class AccountDetailsController {
	@Autowired
	AccountDetailsService service;
	// 1. Get all Account details
	@Autowired
	AccountDetailsRepository repo;
	@GetMapping("/AccountDetails")
	public List<AccountDetails> getAlldetails(){
		
		List<AccountDetails> acc=new ArrayList<AccountDetails>();
		acc=service.getAlldetails();
		return acc;
	}

	
	// 2. Add new Customer details
//	@PostMapping("/AddAccount")
//	public AccountDetails createaccountdetails(@RequestBody AccountDetails accountdetails) {
//	    return service.createaccountdetails(accountdetails);
//	}
	int count=0;
	@PostMapping("/AddAccount")
	public ResponseEntity<Object> createaccountdetails(@RequestBody AccountDetails accountdetails) {
		
		
		if(count!=4) {count++;
		service.createaccountdetails(accountdetails);
		return new ResponseEntity<>("Review is added successfully", HttpStatus.CREATED);}
		else {
			return  new ResponseEntity<>("you cannot create more then 4 account with one pan number", HttpStatus.CREATED);
		}
		
	}
	
//	@GetMapping("/{pan}")
//	public AccountDetails productWithReview(@PathVariable("pan") Long pan) {
//	
//	AccountDetails a=new AccountDetails();
//	a.getAccountnumber();
//	a.getBankname();
//	a.getIfsccode();
//	a.getMicrcode();
//	a.getPan();
//	return a;	
//	}	
	@GetMapping("/{pan}")
	public ResponseEntity<Response> getbypanid(@PathVariable Long pan) {
		Response response = new Response();
		HttpStatus status = HttpStatus.OK;
		try {

			System.out.println("pan: " + repo.findByPan(pan));
			List<AccountDetails> list = repo.findByPan(pan);
			System.out.println("list: " + list);
			if (list.isEmpty()) {
				System.out.println("empty");
				status = HttpStatus.BAD_REQUEST;
				response.setMessage("On data found");

			} else {

				response.setLst(list);
			}

		} catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			response.setMessage("error");
			System.out.println(e);
		}
		return new ResponseEntity<Response>(response, status);

	}


}
