package ma.gloster.microservice.repository.entity;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AccountEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY  )
	private Long idAccount;
	
	private String projectName;
	
	private String token;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="accountEntity")
    private Set<ConfigEntity> configEntitys = new HashSet<>();
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="accountEntity")
    private Set<LogicEntity> logicEntitys = new HashSet<>();
	
	public AccountEntity(String projectName) {
		super();
		this.projectName = projectName;
	}

	public AccountEntity() {
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
	
	public void generateToken() {
		
        try { 
  
            // appel MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
         
            byte[] messageDigest = md.digest(this.projectName.getBytes()); 
  
    
            BigInteger no = new BigInteger(1, messageDigest); 
  
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            this.token =  hashtext; 
        }  

        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
	}

	public Set<ConfigEntity> getConfigEntitys() {
		return configEntitys;
	}

	public void setConfigEntitys(Set<ConfigEntity> configEntitys) {
		this.configEntitys = configEntitys;
	}


	
	
	
	

}
