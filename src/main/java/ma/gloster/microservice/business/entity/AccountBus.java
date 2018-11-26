package ma.gloster.microservice.business.entity;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;


public class AccountBus {
	
	private Long idAccount;
	
	private String projectName;
	
	private String token;
	
    private Set<ConfigBus> configDTOs = new HashSet<>();
	
	

	public AccountBus(Long idAccount, String projectName, String token, Set<ConfigBus> configDTOs) {
		super();
		this.idAccount = idAccount;
		this.projectName = projectName;
		this.token = token;
		this.configDTOs = configDTOs;
	}

	public AccountBus() {
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

	public Set<ConfigBus> getConfigBus() {
		return configDTOs;
	}

	public void setConfigBus(Set<ConfigBus> configDTOs) {
		this.configDTOs = configDTOs;
	}
	
	@Override
	public String toString() {
		return projectName+"="+token+configDTOs.toString();	
	}
	


}
