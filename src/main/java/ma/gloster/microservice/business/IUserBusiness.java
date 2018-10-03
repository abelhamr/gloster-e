package ma.gloster.microservice.business;

import java.util.Date;
import java.util.List;

import ma.gloster.microservice.dto.UserDto;
import ma.gloster.microservice.repository.entity.UserEntity;

/**
 * The Interface IUserBusiness.
 */
public interface IUserBusiness {

	/**
	 * Update user.
	 *
	 * @param userDto
	 *            the user dto
	 */
	public void updateUser(UserDto userDto);

	/**
	 * User authentication.
	 *
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 * @return true, if successful
	 */

	public boolean authenticateUser(String login, String password);
	public List<UserDto> selectUserBydateCreation();
}