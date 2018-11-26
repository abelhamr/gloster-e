package ma.gloster.microservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import groovy.lang.GroovyShell;
import ma.gloster.microservice.dto.DataJson;

@RestController
public class ExecutionGroovyCodeApiController {

	@PostMapping("/codeGroovy")
	public @ResponseBody ResponseEntity<String> executeGroovyCode(@RequestBody DataJson data){
		
		ResponseEntity<String>	responseEntity = new ResponseEntity<>("your code is Ok", HttpStatus.OK);
		
		String processingCode = data.getCode();
	    GroovyShell shell = new GroovyShell();
	    shell.evaluate(processingCode);
		System.out.println("it work for me");
	    
	    return responseEntity;
		
	}

}
