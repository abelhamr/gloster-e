package ma.gloster.microservice.transformation;

import ma.gloster.microservice.dto.ConfigDTO;
import ma.gloster.microservice.repository.entity.ConfigEntity;

public class ConfigTransformation {
	
	public static ConfigDTO configEntity_configDTO(ConfigEntity configEntity) {
		ConfigDTO configDTO = new ConfigDTO();
		
		configDTO.setDbNameOutput(configEntity.getDbNameOutput());
		configDTO.setTimeLunch(configEntity.getTimeLunch());
		configDTO.setDbUrlInput(configEntity.getDbUrlInput());
		configDTO.setFileUrlInput(configEntity.getFileUrlInput());
		configDTO.setTableNameInput(configEntity.getTableNameInput());
		configDTO.setIdConfig(configEntity.getIdConfig());
		
		return configDTO;
	}
	
	public static ConfigEntity configDTO_configEntity(ConfigDTO configDTO) {
		
		ConfigEntity configEntity = new ConfigEntity();
		
		configEntity.setDbNameOutput(configEntity.getDbNameOutput());
		configEntity.setDbUrlInput(configEntity.getDbUrlInput());
		configEntity.setFileUrlInput(configEntity.getFileUrlInput());
		configEntity.setTableNameInput(configEntity.getTableNameInput());
		configEntity.setIdConfig(configEntity.getIdConfig());
		
		return configEntity;
	}

}
