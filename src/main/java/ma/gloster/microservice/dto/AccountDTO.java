package ma.gloster.microservice.dto;


import java.util.HashSet;
import java.util.Set;

import ma.gloster.microservice.repository.entity.ConfigEntity;

public class AccountDTO {
	
	private Long idAccount;
	
	private String projectName;
	
	private String token;
	
    private Set<ConfigDTO> configDTOs = new HashSet<>();
	
	

	public AccountDTO(Long idAccount, String projectName, String token, Set<ConfigDTO> configDTOs) {
		super();
		this.idAccount = idAccount;
		this.projectName = projectName;
		this.token = token;
		this.configDTOs = configDTOs;
	}

	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public Set<ConfigDTO> getConfigDTOs() {
		return configDTOs;
	}

	public void setConfigDTOs(Set<ConfigDTO> configDTOs) {
		this.configDTOs = configDTOs;
	}
	
	@Override
	public String toString() {
		return projectName+"="+token+configDTOs.toString();	
	}

}
