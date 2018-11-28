package ma.gloster.microservice.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ma.gloster.microservice.business.repository.RepositoryAccountBus;
import ma.gloster.microservice.dto.AccountDTO;


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
	public @ResponseBody ResponseEntity<String> createAcounte(@RequestBody String projectName) {
		
		String token = repositoryAccountBus.save(projectName);
		ResponseEntity<String>	responseEntity = new ResponseEntity<>("account created your token is : "+token, HttpStatus.OK);
		return responseEntity;
	}
	
	/**
	 * @param accountDTO
	 * @return
	 */
	@PostMapping("/setConfig")
	public @ResponseBody ResponseEntity<String> setConfig(@RequestBody AccountDTO accountDTO) {
		
		repositoryAccountBus.setConfigAccount(accountDTO);
		
		ResponseEntity<String>	responseEntity = new ResponseEntity<>("config setted : ", HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/getConfig")
	public @ResponseBody String getAllConfig(@RequestBody AccountDTO accountDTO){
		return null;
	}
	
}
