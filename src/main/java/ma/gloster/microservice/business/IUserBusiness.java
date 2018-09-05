package ma.gloster.microservice.business;

import ma.gloster.microservice.dto.UserDto;
import ma.gloster.microservice.exception.BusinessException;

/**
 * The Interface IUserBusiness.
 */
public interface IUserBusiness {
	
	/**
	 * Update user.
	 *
	 * @param userDto the user dto
	 * @throws BusinessException 
	 */
	public void updateUser(UserDto userDto) throws BusinessException;
	
	/**
	 * Afficher user.
	 *
	 * @param userDto the user dto
	 */
	public void AfficherUser(UserDto userDto);

}
