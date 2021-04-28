package de.tekup.loan.rest.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.loan.rest.models.CustomerRequest;
import de.tekup.loan.rest.models.WsResponse;
import de.tekup.loan.rest.service.LoanCheckService;

@RestController
@RequestMapping("/api")
public class LoanRestController {
	
	@Autowired
	private LoanCheckService service;
	
	@PostMapping("/get-status")
	public ResponseEntity<WsResponse> getLoanStatus(@RequestBody CustomerRequest request){
		WsResponse response = service.checkLoanEligeblity(request);
		
		return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
	}

}