package ma.gloster.microservice.batch.writer;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import ma.gloster.microservice.business.IUserBusiness;
import ma.gloster.microservice.dto.UserDto;
import ma.gloster.microservice.exception.BusinessException;

/**
 * The Class UserWriterImpl.
 */
public class UserWriterImpl implements ItemWriter<UserDto> {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(UserWriterImpl.class);
	/** The user business. */
	@Autowired
	public IUserBusiness userBusiness;

	/**
	 * Instantiates a new user writer impl.
	 */
	public UserWriterImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
	 */
	@Override
	public void write(List<? extends UserDto> listUser) throws BusinessException {
		logger.info("> Début UserWriterImpl.write");
		for (UserDto userDto : listUser) {
			userBusiness.updateUser(userDto);
		}
		logger.info("< Fin UserWriterImpl.write");
	}

}
