package ma.gloster.microservice.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ma.gloster.microservice.business.entity.AccountBus;
import ma.gloster.microservice.business.repository.RepositoryAccountBus;
import ma.gloster.microservice.dto.AccountDTO;

import ma.gloster.microservice.dto.repository.RepositoryAcountDTO;
import ma.gloster.microservice.mapper.AccountMapper;



@RestController
public class AccessController {

	@Autowired
	RepositoryAccountBus repositoryAccountBus;
	
	
	/**
	 * @param accountDTO
	 * @return
	 */
	@PostMapping("/createAccount")
	public @ResponseBody ResponseEntity<String> createAcounte(@RequestBody AccountDTO accountDTO) {
		
		AccountBus accountBus = AccountMapper.AccountDtoMappring(accountDTO);
		String token = repositoryAccountBus.save(accountBus);
		ResponseEntity<String>	responseEntity = new ResponseEntity<>("account created your token is : "+token, HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/setConfig")
	public @ResponseBody ResponseEntity<String> setConfig(@RequestBody AccountDTO accountDTO) {
		ResponseEntity<String>	responseEntity = new ResponseEntity<>("config setted : ", HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/getConfig")
	public @ResponseBody String getAllConfig(@RequestBody AccountDTO accountDTO){
		return null;
	}
	
}
