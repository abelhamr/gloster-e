package ma.gloster.microservice.dto;


import java.util.HashSet;
import java.util.Set;

import ma.gloster.microservice.repository.entity.ConfigEntity;

public class AccountDTO {
	
	private Long idAccount;
	
	private String projectName;
	
	private String token;
	
    private ConfigDTO configDTO;
	
	

	

	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDTO(String projectName, String token, ConfigDTO configDTO) {
		super();
		this.projectName = projectName;
		this.token = token;
		this.configDTO = configDTO;
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	
	public ConfigDTO getConfigDTO() {
		return configDTO;
	}

	public void setConfigDTO(ConfigDTO configDTO) {
		this.configDTO = configDTO;
	}

	@Override
	public String toString() {
		return projectName+"="+token+configDTO.toString();	
	}

}
