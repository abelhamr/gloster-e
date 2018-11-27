package ma.gloster.microservice.mapper;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ma.gloster.microservice.business.entity.AccountBus;
import ma.gloster.microservice.business.entity.ConfigBus;
import ma.gloster.microservice.dto.AccountDTO;
import ma.gloster.microservice.dto.ConfigDTO;
import ma.gloster.microservice.repository.entity.AccountEntity;
import ma.gloster.microservice.repository.entity.ConfigEntity;

/**
 * @author youness
 *
 */
public class AccountMapper {
	
	
	/**
	 * @param accountEntity
	 * @return
	 */
	public static AccountBus AccountEntityInfraMapping(AccountEntity accountEntity) {
		AccountBus accountBus = new AccountBus();
		accountBus.setConfigBus(getSetConfigBus(accountEntity.getConfigEntitys()));
		accountBus.setProjectName(accountEntity.getProjectName());
		accountBus.setToken(accountEntity.getToken());
		accountBus.setIdAccount(accountEntity.getIdAccount());
		
		return accountBus;
	}
	/**
	 * @param accountBus
	 * @return
	 */
	public static AccountEntity AccountBusInfraMapping(AccountBus accountBus) {
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setConfigEntitys(getSetConfigEntity(accountBus.getConfigBus()));
		accountEntity.setProjectName(accountBus.getProjectName());
		accountEntity.setToken(accountBus.getToken());
		accountEntity.setIdAccount(accountBus.getIdAccount());
		
		return accountEntity;
	}
	
	public static AccountEntity AccountDTOInfraMapping(AccountDTO accountDTO) {
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.getConfigEntitys().add(ConfigMapper.ConfigBusInfraMapping(ConfigMapper.ConfigDtoMapping(accountDTO.getConfigDTO())));
		accountEntity.setProjectName(accountDTO.getProjectName());
		accountEntity.setToken(accountDTO.getToken());
		accountEntity.setIdAccount(accountDTO.getIdAccount());
		
		return accountEntity;
	}
	
	
	
	
	
	/**
	 * @param configEntitys
	 * @return
	 */
	private static Set<ConfigBus> getSetConfigBus(Set<ConfigEntity> configEntitys){
		Set<ConfigBus> configs = new HashSet<>();
		Iterator<ConfigEntity> configsIterator = configEntitys.iterator();
		
		while(configsIterator.hasNext()) {
			ConfigEntity c = configsIterator.next();
			ConfigBus congifBus = ConfigMapper.ConfigEntityInfraMapping(c);
			
			configs.add(congifBus);
			
		}
		
		return configs;
	}
	
	/**
	 * @param configBus
	 * @return
	 */
	private static Set<ConfigEntity> getSetConfigEntity(Set<ConfigBus> configBus){
		Set<ConfigEntity> configs = new HashSet<>();
		Iterator<ConfigBus> configsIterator = configBus.iterator();
		
		while(configsIterator.hasNext()) {
			ConfigBus c = configsIterator.next();
			ConfigEntity congifEntity = ConfigMapper.ConfigBusInfraMapping(c);
			
			configs.add(congifEntity);
			
		}
		
		return configs;
	}
	
	/**
	 * @param accountDTO
	 * @return
	 */
	public static AccountBus AccountDtoMappring(AccountDTO accountDTO) {
		
		AccountBus accountBus = new AccountBus();
		accountBus.setProjectName(accountDTO.getProjectName());
		accountBus.setToken(accountDTO.getToken());
		accountBus.setIdAccount(accountDTO.getIdAccount());
		
		return accountBus;
	}
	
	/**
	 * @param configDTOs
	 * @return
	 */
	private static Set<ConfigBus> getSetConfigDTO(Set<ConfigDTO> configDTOs){
		Set<ConfigBus> configs = new HashSet<>();
		Iterator<ConfigDTO> configsIterator = configDTOs.iterator();
		
		while(configsIterator.hasNext()) {
			ConfigDTO c = configsIterator.next();
			ConfigBus congifBus = ConfigMapper.ConfigDtoMapping(c);
			
			configs.add(congifBus);
			
		}
		
		return configs;
	}
	
	

}
