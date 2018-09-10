package ma.gloster.microservice.business;

import ma.gloster.microservice.dto.UserDto;

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
}