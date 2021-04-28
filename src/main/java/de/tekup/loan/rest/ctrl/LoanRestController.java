package de.tekup.loan.rest.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.loan.rest.models.CustomerRequest;
import de.tekup.loan.rest.models.WsResponse;
import de.tekup.loan.rest.service.LoanCheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(description = "Service to check eligeblity of client that want to get a bank loan")
public class LoanRestController {
	
	@Autowired
	private LoanCheckService service;
	
	@ApiOperation(value = "check customer for a loan", response = WsResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfuly get a status")
	})
	@PostMapping(path = "/get-status", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
									, consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<WsResponse> getLoanStatus(@RequestBody CustomerRequest request){
		WsResponse response = service.checkLoanEligeblity(request);
		
		return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
	}

}
