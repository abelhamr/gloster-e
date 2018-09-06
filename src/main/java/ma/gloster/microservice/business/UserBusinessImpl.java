package ma.gloster.microservice.business;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ma.gloster.microservice.dto.UserDto;
import ma.gloster.microservice.exception.BusinessException;
import ma.gloster.microservice.repository.UserRepository;

/**
 * The Class UserBusinessImpl.
 */
@Transactional
@Service
public class UserBusinessImpl implements IUserBusiness {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(UserBusinessImpl.class);

	/** The user repository. */
	@Autowired
	public UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ma.gloster.microservice.business.IUserBusiness#updateUser(ma.gloster.
	 * microservice.dto.UserDto)
	 */
	public void updateUser(UserDto userDto) throws BusinessException {
		logger.info("> Début UserBusinessImpl.updateUser");
		try {
			userRepository.updateUser(userDto.getAddress(), userDto.getStatus(), userDto.getEmail());
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		logger.info("< Fin UserBusinessImpl.updateUser");
	}
}
