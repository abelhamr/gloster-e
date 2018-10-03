package ma.gloster.microservice.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ma.gloster.microservice.dto.UserDto;
import ma.gloster.microservice.repository.UserRepository;
import ma.gloster.microservice.repository.entity.UserEntity;

/**
 * The Class UserBusinessImpl.
 */
@Transactional
@Service
public class UserBusinessImpl implements IUserBusiness {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(UserBusinessImpl.class);
	Date date = new Date();

	@Value("${spring.controler.userInJob.password}")
	private String password;

	/** The email. */
	@Value("${spring.controler.userInJob.login}")
	private String login;

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
	public void updateUser(UserDto userDto) {
		logger.info("> Début UserBusinessImpl.updateUser");
		userRepository.updateUser(userDto.getAddress(), userDto.getStatus(), userDto.getEmail());
		logger.info("< Fin UserBusinessImpl.updateUser");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ma.gloster.microservice.business.IUserBusiness#authenticateUser(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public boolean authenticateUser(String login, String password) {
		return !login.isEmpty() && !password.isEmpty() && login.equals(this.login) && password.equals(this.password);
	}
	
	@Override
	public List<UserDto> selectUserBydateCreation(){
		 return userRepository.selectUserBydateCreation();
	
	}
	
}