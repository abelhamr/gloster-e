package ma.gloster.microservice.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.gloster.microservice.dto.UserDto;
import ma.gloster.microservice.repository.entity.UserEntity;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	/** The Constant logger. */
	/**
	 * Update user.
	 *
	 * @param adress
	 *            the adress
	 * @param statut
	 *            the statut
	 * @param email
	 *            the email
	 */
	@Transactional
	@Modifying
	@Query("update UserEntity u set u.adress = ?1  , u.statut = ?2 where u.email = ?3")
	public void updateUser(String adress, String statut, String email);
	
	@Query("select u.adress from UserEntity u ")
	public List<UserDto> selectUserBydateCreation();
	
}
