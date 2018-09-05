package ma.gloster.microservice.batch.config;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import ma.gloster.microservice.dto.UserDto;
import ma.gloster.microservice.exception.BusinessException;
import ma.gloster.microservice.batch.writer.UserWriterImpl;
import ma.gloster.microservice.batch.processor.UserProcessorImpl;
import ma.gloster.microservice.batch.reader.UserReaderImpl;

/**
 * The Class BatchUserConfig.
 */
@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchUserConfig {

	/** The job builder factory. */
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	/** The step builder factory. */
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	/** The users in job. */
	@Value("${spring.job.userInJob.name}")
	private String usersInJob;

	/** The file input path. */
	@Value("${spring.job.userInJob.input}")
	private String fileInputPath;

	/** The user in job header. */
	@Value("${spring.job.userInJob.header}")
	private String userInJobHeader;

	/**
	 * Job.
	 *
	 * @return the job
	 */
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(BatchUserConfig.class);

	@Bean
	public Job job() throws BusinessException {
		logger.info("< Démarage BatchUserConfig.job");
		return jobBuilderFactory.get(usersInJob).incrementer(new RunIdIncrementer()).flow(step1()).end().build();
	}

	/**
	 * Step 1.
	 *
	 * @return the step
	 * @throws BusinessException 
	 */
	@Bean
	public Step step1() throws BusinessException {
		logger.info("< Démarage BatchUserConfig.step1");
		return stepBuilderFactory.get("step1").<UserDto, UserDto>chunk(2).reader(read())
				.processor(new UserProcessorImpl()).writer(write()).build();
	}

	/**
	 * Write.
	 *
	 * @return the user writer impl
	 */
	@Bean
	public UserWriterImpl write() throws BusinessException{
		logger.info("< Démarage BatchUserConfig.UserWriterImpl");
		return new UserWriterImpl();
	}

	/**
	 * Read.
	 *
	 * @return the flat file item reader
	 */
	@Bean
	public FlatFileItemReader<UserDto> read() {
		logger.info("< Démarage BatchUserConfig.FlatFileItemReader");
		return new UserReaderImpl().reader(userInJobHeader, fileInputPath);
	}
}
