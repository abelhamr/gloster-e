package ma.gloster.microservice.transformation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ma.gloster.microservice.dto.AccountDTO;
import ma.gloster.microservice.dto.ConfigDTO;
import ma.gloster.microservice.repository.entity.AccountEntity;
import ma.gloster.microservice.repository.entity.ConfigEntity;

public class AccountTransformation {
	
	
	public static AccountEntity AccountDTO_AccountEntity(AccountDTO accountDTO) {
		AccountEntity accountEntity = new AccountEntity();
		
		accountEntity.setProjectName(accountDTO.getProjectName());
		
		return accountEntity;
	}
	
	public static AccountDTO AccountEntity_AccountDTO(AccountEntity accountEntity) {
		AccountDTO accountDTO = new AccountDTO();
		Set<ConfigDTO> configs  = setConfigDTOs(accountEntity);
		accountDTO.setConfigDTOs(configs);
		accountDTO.setIdAccount(accountEntity.getIdAccount());
		accountDTO.setProjectName(accountEntity.getProjectName());
		accountDTO.setToken(accountEntity.getToken());
		
		return accountDTO;
	}
	
	public static Set<ConfigDTO> setConfigDTOs(AccountEntity accountEntity){
		
		Set<ConfigDTO> configs = new HashSet<>();
		Iterator<ConfigEntity> setConfigs = accountEntity.getConfigEntitys().iterator(); 
		while(setConfigs.hasNext()) {
			ConfigEntity config = setConfigs.next();
			configs.add(ConfigTransformation.configEntity_configDTO(config));
		}
		
		return configs;
	}
	
	public static Set<ConfigEntity> setConfigEntitys(AccountDTO accountDTO){
		
		Set<ConfigEntity> configs = new HashSet<>();
		Iterator<ConfigDTO> setConfigs = accountDTO.getConfigDTOs().iterator(); 
		while(setConfigs.hasNext()) {
			ConfigDTO config = setConfigs.next();
			configs.add(ConfigTransformation.configDTO_configEntity(config));
		}
		
		return configs;
	}


}
