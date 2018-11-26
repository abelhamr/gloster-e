package ma.gloster.microservice.mapper;

import ma.gloster.microservice.business.entity.ConfigBus;
import ma.gloster.microservice.dto.ConfigDTO;
import ma.gloster.microservice.repository.entity.ConfigEntity;

public class ConfigMapper {
	
	public static ConfigBus ConfigEntityInfraMapping(ConfigEntity configEntity) {
		ConfigBus configBus = new ConfigBus();
		
		configBus.setIdConfig(configEntity.getIdConfig());
		configBus.setTimeLunch(configEntity.getTimeLunch());
		configBus.setTableNameInput(configEntity.getTableNameInput());
		configBus.setFileUrlInput(configEntity.getFileUrlInput());
		configBus.setDbUrlInput(configEntity.getDbUrlInput());
		
		return configBus;
	}
	
	public static ConfigEntity ConfigBusInfraMapping(ConfigBus configBus) {
		ConfigEntity configEntity = new ConfigEntity();
		
		configEntity.setIdConfig(configBus.getIdConfig());
		configEntity.setTimeLunch(configBus.getTimeLunch());
		configEntity.setTableNameInput(configBus.getTableNameInput());
		configEntity.setFileUrlInput(configBus.getFileUrlInput());
		configEntity.setDbUrlInput(configBus.getDbUrlInput());
		
		return configEntity;
	}
	
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
