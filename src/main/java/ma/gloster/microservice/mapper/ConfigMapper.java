package ma.gloster.microservice.mapper;

import ma.gloster.microservice.business.entity.ConfigBus;
import ma.gloster.microservice.dto.ConfigDTO;
import ma.gloster.microservice.repository.entity.ConfigEntity;

/**
 * @author youness
 *
 */
public class ConfigMapper {
	
	/**
	 * @param configEntity
	 * @return
	 */
	public static ConfigBus ConfigEntityInfraMapping(ConfigEntity configEntity) {
		ConfigBus configBus = new ConfigBus();
		
		configBus.setIdConfig(configEntity.getIdConfig());
		configBus.setTimeLunch(configEntity.getTimeLunch());
		configBus.setTableNameInput(configEntity.getTableNameInput());
		configBus.setFileUrlInput(configEntity.getFileUrlInput());
		configBus.setDbUrlInput(configEntity.getDbUrlInput());
		
		return configBus;
	}
	
	/**
	 * @param configBus
	 * @return
	 */
	public static ConfigEntity ConfigBusInfraMapping(ConfigBus configBus) {
		ConfigEntity configEntity = new ConfigEntity();
		
		configEntity.setIdConfig(configBus.getIdConfig());
		configEntity.setTimeLunch(configBus.getTimeLunch());
		configEntity.setTableNameInput(configBus.getTableNameInput());
		configEntity.setFileUrlInput(configBus.getFileUrlInput());
		configEntity.setDbUrlInput(configBus.getDbUrlInput());
		
		return configEntity;
	}
	
	/**
	 * @param configDTO
	 * @return
	 */
	public static ConfigEntity ConfigDTOMapping(ConfigDTO configDTO) {
		ConfigEntity configEntity = new ConfigEntity();
		
		configEntity.setIdConfig(configDTO.getIdConfig());
		configEntity.setTimeLunch(configDTO.getTimeLunch());
		configEntity.setTableNameInput(configDTO.getTableNameInput());
		configEntity.setFileUrlInput(configDTO.getFileUrlInput());
		configEntity.setDbUrlInput(configDTO.getDbUrlInput());
		
		return configEntity;
	}
	
	/**
	 * @param configDTO
	 * @return
	 */
	public static ConfigBus ConfigDtoMapping(ConfigDTO configDTO) {
		ConfigBus configBus = new ConfigBus();
		
		configBus.setIdConfig(configDTO.getIdConfig());
		configBus.setTimeLunch(configDTO.getTimeLunch());
		configBus.setTableNameInput(configDTO.getTableNameInput());
		configBus.setFileUrlInput(configDTO.getFileUrlInput());
		configBus.setDbUrlInput(configDTO.getDbUrlInput());
		
		return configBus;
	}


}
