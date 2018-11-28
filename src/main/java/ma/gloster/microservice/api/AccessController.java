package ma.gloster.microservice.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ma.gloster.microservice.business.BatchExecution;
import ma.gloster.microservice.business.entity.AccountBus;
import ma.gloster.microservice.business.repository.RepositoryAccountBus;
import ma.gloster.microservice.dto.AccountDTO;
import ma.gloster.microservice.dto.LogicDTO;
import ma.gloster.microservice.dto.ResponseDTO;
import ma.gloster.microservice.dto.repository.RepositoryAcountDTO;
import ma.gloster.microservice.mapper.AccountMapper;



/**
 * @author youness
 *
 */
@RestController
public class AccessController {

	@Autowired
	RepositoryAccountBus repositoryAccountBus;
	
	
	/**
	 * @param accountDTO
	 * @return
	 */
	@PostMapping("/createAccount")
	public @ResponseBody ResponseEntity<ResponseDTO> createAcounte(@RequestBody AccountDTO accountDTO) {
		
		String token = repositoryAccountBus.save(accountDTO);
		ResponseDTO responseDTO = new ResponseDTO("account created your token is",token);
		ResponseEntity<ResponseDTO>	responseEntity = new ResponseEntity<>(responseDTO, HttpStatus.OK);
		return responseEntity;
	}
	
	/**
	 * @param accountDTO
	 * @return
	 */
	@PostMapping("/setConfig")
	public @ResponseBody ResponseEntity<ResponseDTO> setConfig(@RequestBody AccountDTO accountDTO) {
	
		repositoryAccountBus.setConfigAccount(accountDTO);
		ResponseDTO responseDTO = new ResponseDTO("config setted");
		ResponseEntity<ResponseDTO>	responseEntity = new ResponseEntity<>(responseDTO, HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/executeLogique")
	public @ResponseBody ResponseEntity<ResponseDTO> setLogiqueForProject(@RequestBody LogicDTO logicDTO ){
		
		if(logicDTO.getGroovyFunction()!=null && logicDTO.getGroovyFunction().length()!= 0 ) {
			BatchExecution.executeGroovyScript(logicDTO.getGroovyFunction());
		}else {
			BatchExecution.executeSqlQuery(logicDTO.getSqlQuery());
		}
		ResponseDTO responseDTO = new ResponseDTO("your treatment is in");
		ResponseEntity<ResponseDTO>	responseEntity = new ResponseEntity<>(responseDTO, HttpStatus.OK);
		return responseEntity;
	}
	@PostMapping("/getConfig")
	public @ResponseBody String getAllConfig(@RequestBody AccountDTO accountDTO){
		return null;
	}
	
}
