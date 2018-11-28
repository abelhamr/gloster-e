package ma.gloster.microservice.repository.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LogicEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idL;
	
	private String groovyFunction;
	private String sqlQuery;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private AccountEntity accountEntity;
	
	public LogicEntity(String groovyFunction, String sqlQuery, AccountEntity accountEntity) {
		super();
		this.groovyFunction = groovyFunction;
		this.sqlQuery = sqlQuery;
		this.accountEntity = accountEntity;
	}
	public LogicEntity() {
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
	public AccountEntity getAccountEntity() {
		return accountEntity;
	}
	public void setAccountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
	}
	
	
	
	

}
