package ma.gloster.microservice.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.apache.log4j.Logger;
import ma.gloster.microservice.dto.UserDto;

/**
 * The Class UserProcessorImpl.
 */
public class UserProcessorImpl implements ItemProcessor<UserDto, UserDto> {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(UserProcessorImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
	 */
	public UserDto process(UserDto user) throws Exception {
		/*logger.info("> Début UserProcessor.process");
		final String address = user.getAddress();
		final String email = user.getEmail();
		final String status = user.getStatus();
		final UserDto fixedCustomer = new UserDto(address, email, status);
		logger.info("< Fin UserProcessor.process");

		return fixedCustomer;*/
	
		return user;
	}
	
}
