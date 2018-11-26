package ma.gloster.microservice.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.gloster.microservice.repository.entity.AccountEntity;
import ma.gloster.microservice.repository.entity.ConfigEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long>{
	
	@Query("select a from AccountEntity a where a.token=:t")
    public AccountEntity getProjectByToken(@Param("t")String token);
	@Query("select a from AccountEntity a where a.projectName=:name")
	public AccountEntity getAccountByProjectName(@Param("name") String name);
	@Query("select a.configEntitys from AccountEntity a where a.token = :token")
	public Set<ConfigEntity> getConfigBytoken(@Param("token") String token);
	
}
