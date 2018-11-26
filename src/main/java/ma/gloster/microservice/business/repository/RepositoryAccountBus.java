package ma.gloster.microservice.business.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.gloster.microservice.business.entity.AccountBus;
import ma.gloster.microservice.business.entity.ConfigBus;
import ma.gloster.microservice.dto.AccountDTO;
import ma.gloster.microservice.dto.ConfigDTO;
import ma.gloster.microservice.mapper.AccountMapper;
import ma.gloster.microservice.mapper.ConfigMapper;
import ma.gloster.microservice.repository.AccountRepository;
import ma.gloster.microservice.repository.ConfigRepository;
import ma.gloster.microservice.repository.entity.AccountEntity;
import ma.gloster.microservice.repository.entity.ConfigEntity;
import ma.gloster.microservice.transformation.AccountTransformation;
import ma.gloster.microservice.transformation.ConfigTransformation;

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
	public String save(AccountBus accountBus) {
		
		AccountEntity accountEntity = AccountMapper.AccountBusInfraMapping(accountBus);
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
	 * @param accountDTO
	 */
	public void setAccountByProjecName(AccountBus accountBus) {
		AccountEntity accountEntity = accountRepository.getAccountByProjectName(accountBus.getProjectName());
		System.out.println(accountEntity.toString());
		ConfigBus c = accountBus.getConfigBus().iterator().next();
		accountEntity.getConfigEntitys().add(ConfigMapper.ConfigBusInfraMapping(c));
		System.out.println(accountEntity.toString());
		//accountEntity.getConfigEntitys().addAll(AccountTransformation.setConfigEntitys(accountDTO));
		//accountRepository.save(accountEntity);
	}
	
	/**
	 * @param accountDTO
	 * @return
	 */
	public Set<ConfigDTO> getConfigBytoken(AccountDTO accountDTO){
		Set<ConfigDTO> configs = new HashSet<>();
		AccountEntity account  = accountRepository.getAccountByProjectName(accountDTO.getProjectName());
		Set<ConfigEntity> myConfigEntitys = configRepository.getConfigByAccount(account);
		Iterator<ConfigEntity> setIterator = myConfigEntitys.iterator();
		
		while(setIterator.hasNext()) {
			ConfigEntity configEntity = setIterator.next();
			configs.add(ConfigTransformation.configEntity_configDTO(configEntity));
		}
		
		return configs;
	}

}
