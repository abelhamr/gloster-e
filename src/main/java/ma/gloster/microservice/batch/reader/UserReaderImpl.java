package ma.gloster.microservice.batch.reader;

import org.apache.log4j.Logger;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import ma.gloster.microservice.dto.UserDto;

/**
 * The Class UserReaderImpl.
 */
public class UserReaderImpl {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(UserReaderImpl.class);

	/** The Constant INPUT_FILE_DELEMITER. */
	private static final String INPUT_FILE_DELEMITER = ",";

	/**
	 * Reader.
	 *
	 * @param userInJobHeader
	 *            the user in job header
	 * @param fileInputPath
	 *            the file input path
	 * @return the flat file item reader
	 */
	@Bean
	public FlatFileItemReader<UserDto> reader(String userInJobHeader, String fileInputPath) {
		logger.info("> Début UserReaderImpl.reader");
		FlatFileItemReader<UserDto> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource(fileInputPath));
		DefaultLineMapper<UserDto> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setNames(userInJobHeader.split(INPUT_FILE_DELEMITER));
		defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		BeanWrapperFieldSetMapper<UserDto> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		beanWrapperFieldSetMapper.setTargetType(UserDto.class);
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		reader.setLineMapper(defaultLineMapper);
		logger.info("< Fin UserReaderImpl.reader");
		return reader;
	}
}
