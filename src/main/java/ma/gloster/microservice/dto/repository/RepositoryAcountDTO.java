package ma.gloster.microservice.dto.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.gloster.microservice.dto.AccountDTO;
import ma.gloster.microservice.dto.ConfigDTO;
import ma.gloster.microservice.mapper.AccountMapper;
import ma.gloster.microservice.repository.AccountRepository;
import ma.gloster.microservice.repository.ConfigRepository;
import ma.gloster.microservice.repository.entity.AccountEntity;
import ma.gloster.microservice.repository.entity.ConfigEntity;

@Component
public class RepositoryAcountDTO {
	
	
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ConfigRepository configRepository;
	
	public String save(AccountDTO accountDTO) {
		
		AccountEntity accountEntity = AccountMapper.AccountDTOInfraMapping(accountDTO);
		accountEntity.generateToken();
		String token = accountEntity.getToken();
		
		this.accountRepository.save(accountEntity);
		
		return token;
	}

	public void setAccountByProjecName(AccountDTO accountDTO) {
		AccountEntity accountEntity = accountRepository.getAccountByProjectName(accountDTO.getProjectName());
//		System.out.println(accountEntity.toString());
//		ConfigDTO c = accountDTO.getConfigDTOs().iterator().next();
//		accountEntity.getConfigEntitys().add(ConfigTransformation.configDTO_configEntity(c));
//		System.out.println(accountEntity.toString());
		//accountEntity.getConfigEntitys().addAll(AccountTransformation.setConfigEntitys(accountDTO));
		//accountRepository.save(accountEntity);
	}
	
	

}
