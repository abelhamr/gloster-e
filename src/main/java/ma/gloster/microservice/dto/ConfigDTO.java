package ma.gloster.microservice.dto;


import ma.gloster.microservice.repository.entity.AccountEntity;

public class ConfigDTO {
	
	private Integer idConfig;
	
	private String dbUrlInput;
	private String tableNameInput;
	private String fileUrlInput;
	private String dbNameOutput;
	private String timeLunch;

	private AccountEntity accountEntity;
	
	
	public ConfigDTO(Integer idConfig, String dbUrlInput, String tableNameInput, String fileUrlInput,
			String dbNameOutput, String timeLunch, AccountEntity accountEntity) {
		super();
		this.idConfig = idConfig;
		this.dbUrlInput = dbUrlInput;
		this.tableNameInput = tableNameInput;
		this.fileUrlInput = fileUrlInput;
		this.dbNameOutput = dbNameOutput;
		this.timeLunch = timeLunch;
		this.accountEntity = accountEntity;
	}


	public ConfigDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	
	@Override
	public String toString() {
		return "{ dbNameOutput:"+dbNameOutput+","+
	              "dbUrlInput:"+dbUrlInput+","+
	              "fileUrlInput:"+fileUrlInput+","+
	              "tableNameInput:"+tableNameInput+","+
	              "timeLunch:"+timeLunch+","+"}";
	}

}
