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
	
		return user;
	}
	
}
