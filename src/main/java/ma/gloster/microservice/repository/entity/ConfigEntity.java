package ma.gloster.microservice.repository.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class ConfigEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConfig;
	
	private String dbUrlInput;
	private String tableNameInput;
	private String fileUrlInput;
	private String dbNameOutput;
	private String timeLunch;

	@ManyToOne(fetch = FetchType.LAZY)
	private AccountEntity accountEntity;


	public ConfigEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ConfigEntity(String dbUrlInput, String tableNameInput, String fileUrlInput, String dbNameOutput,
			String timeLunch, AccountEntity accountEntity) {
		super();
		this.dbUrlInput = dbUrlInput;
		this.tableNameInput = tableNameInput;
		this.fileUrlInput = fileUrlInput;
		this.dbNameOutput = dbNameOutput;
		this.timeLunch = timeLunch;
		this.accountEntity = accountEntity;
	}


	public ConfigEntity(String dbUrlInput, String tableNameInput, String fileUrlInput, String dbNameOutput,
			String timeLunch) {
		super();
		this.dbUrlInput = dbUrlInput;
		this.tableNameInput = tableNameInput;
		this.fileUrlInput = fileUrlInput;
		this.dbNameOutput = dbNameOutput;
		this.timeLunch = timeLunch;
	}


	public Integer getIdConfig() {
		return idConfig;
	}


	public void setIdConfig(Integer idConfig) {
		this.idConfig = idConfig;
	}


	public String getDbUrlInput() {
		return dbUrlInput;
	}


	public void setDbUrlInput(String dbUrlInput) {
		this.dbUrlInput = dbUrlInput;
	}


	public String getTableNameInput() {
		return tableNameInput;
	}


	public void setTableNameInput(String tableNameInput) {
		this.tableNameInput = tableNameInput;
	}


	public String getFileUrlInput() {
		return fileUrlInput;
	}


	public void setFileUrlInput(String fileUrlInput) {
		this.fileUrlInput = fileUrlInput;
	}


	public String getDbNameOutput() {
		return dbNameOutput;
	}


	public void setDbNameOutput(String dbNameOutput) {
		this.dbNameOutput = dbNameOutput;
	}


	public String getTimeLunch() {
		return timeLunch;
	}


	public void setTimeLunch(String timeLunch) {
		this.timeLunch = timeLunch;
	}


	public AccountEntity getAccountEntity() {
		return accountEntity;
	}


	public void setAccountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
	}
	
	
	
	

}
