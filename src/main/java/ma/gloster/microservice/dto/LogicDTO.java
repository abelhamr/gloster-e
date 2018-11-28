package ma.gloster.microservice.dto;



public class LogicDTO {
	
	private Long idL;
	
	private String groovyFunction;
	private String sqlQuery;
	
	private AccountDTO accountDTO;
	
	public LogicDTO(String groovyFunction, String sqlQuery, AccountDTO accountDTO) {
		super();
		this.groovyFunction = groovyFunction;
		this.sqlQuery = sqlQuery;
		this.accountDTO = accountDTO;
	}
	public LogicDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdL() {
		return idL;
	}
	public void setIdL(Long idL) {
		this.idL = idL;
	}
	public String getGroovyFunction() {
		return groovyFunction;
	}
	public void setGroovyFunction(String groovyFunction) {
		this.groovyFunction = groovyFunction;
	}
	public String getSqlQuery() {
		return sqlQuery;
	}
	public void setSqlQuery(String sqlQuery) {
		this.sqlQuery = sqlQuery;
	}
	public AccountDTO getAccountDTO() {
		return accountDTO;
	}
	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}
	
	
	@Override
	public String toString() {
		if(this.groovyFunction!=null && this.groovyFunction.length()!=0) {
			return this.groovyFunction+" "+this.accountDTO.toString();	
		}else {
			if(this.sqlQuery.length()!=0) {
				return this.sqlQuery+""+this.accountDTO.toString();	
			}
		return null;	
		}
		
	}
	


}
