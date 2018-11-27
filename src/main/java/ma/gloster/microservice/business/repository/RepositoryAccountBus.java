package ma.gloster.microservice.business.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.gloster.microservice.business.entity.AccountBus;
import ma.gloster.microservice.business.entity.ConfigBus;
import ma.gloster.microservice.dto.AccountDTO;
import ma.gloster.microservice.mapper.AccountMapper;
import ma.gloster.microservice.mapper.ConfigMapper;
import ma.gloster.microservice.repository.AccountRepository;
import ma.gloster.microservice.repository.ConfigRepository;
import ma.gloster.microservice.repository.entity.AccountEntity;
import ma.gloster.microservice.repository.entity.ConfigEntity;


/**
 * @author youness
 *
 */
@Component
public class RepositoryAccountBus {
	
	
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ConfigRepository configRepository;
	
	/**
	 * @param accountBus
	 * @return
	 */
	public String save(String projectName) {
		
		AccountEntity accountEntity = new AccountEntity(projectName);
		accountEntity.generateToken();
		String token = accountEntity.getToken();
		
		this.accountRepository.save(accountEntity);
		
		return token;
	}
	
	/**
	 * @param token
	 * @return
	 */
	public AccountBus getProjectByToken(String token) {
		return AccountMapper.AccountEntityInfraMapping(accountRepository.getProjectByToken(token));
	}
	
	
	/**	    
	    System.out.println("ok votre config a ete mise");
	 * @param accountDTO
	 */
	public void setConfigAccount(AccountDTO accountDTO) {
		
	    AccountEntity accountEntity = accountRepository.getProjectByToken(accountDTO.getToken());
	    ConfigEntity configEntity = ConfigMapper.ConfigDTOMapping(accountDTO.getConfigDTO());
	    
	    accountEntity.getConfigEntitys().add(configEntity)	;
	    configEntity.setAccountEntity(accountEntity);
	    
	    accountRepository.save(accountEntity);

		
	}
	

}
