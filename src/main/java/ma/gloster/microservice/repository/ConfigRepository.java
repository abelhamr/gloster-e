package ma.gloster.microservice.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.gloster.microservice.repository.entity.AccountEntity;
import ma.gloster.microservice.repository.entity.ConfigEntity;

public interface ConfigRepository extends JpaRepository<ConfigEntity, Integer> {
	
	@Query("select c from ConfigEntity c where c.accountEntity=:account")
	public Set<ConfigEntity> getConfigByAccount(@Param("account") AccountEntity account);

}
