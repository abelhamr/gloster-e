package ma.gloster.microservice.batch.config;


import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import ma.gloster.microservice.dto.UserDto;
import ma.gloster.microservice.dto.repository.RepositoryAcountDTO;
import ma.gloster.microservice.exception.BusinessException;
import ma.gloster.microservice.batch.writer.UserWriterImpl;
import ma.gloster.microservice.batch.writer.UserWriterToCsvImpl;
import ma.gloster.microservice.batch.processor.UserProcessorImpl;
import ma.gloster.microservice.batch.reader.UserReaderDbImpl;
import ma.gloster.microservice.batch.reader.UserReaderImpl;

/**
 * The Class BatchUserConfig.
 */
@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchUserConfig {

	/** The users in job. */
	@Value("${spring.job.userInJob.name}")
	private String usersInJob;

	/** The file input path. */
	@Value("${spring.job.userInJob.input}")
	private String fileInputPath;

	@Value("${spring.job.userInJob.output}")
	private String fileoutputPath;
	
	/** The user in job header. */
	@Value("${spring.job.userInJob.header}")
	private String userInJobHeader;
	
	@Value("${spring.job.userOutJob.name}")
	private String userOutJob;
	
	


	/**
	 * Job.
	 *
	 * @return the job
	 */
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(BatchUserConfig.class);
   private UserReaderDbImpl userReaderDbImpl = new UserReaderDbImpl();
   private UserWriterToCsvImpl userWriterToCsvImpl=new UserWriterToCsvImpl();
	
 @Primary
	@Bean(name="userInJob")
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		logger.info("< Début BatchUserConfig.job");
		return jobBuilderFactory.get(usersInJob).incrementer(new RunIdIncrementer()).flow(step1(stepBuilderFactory))
				.end().build();
	}
	
	
	@Bean(name="userOutJob")
	public Job job1(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		logger.info("< Début BatchUserConfig.job");
		return jobBuilderFactory.get(userOutJob).incrementer(new RunIdIncrementer()).flow(step2(stepBuilderFactory))
				.end().build();
	}

	/**
	 * Step 1.
	 *
	 * @return the step
	 * @throws BusinessException
	 */
	@Bean
	public Step step1(StepBuilderFactory stepBuilderFactory) {
		logger.info("< Début BatchUserConfig.step1");
		return stepBuilderFactory.get("step1").<UserDto, UserDto>chunk(2).reader(read())
				.processor(new UserProcessorImpl()).writer(write()).build();
	}
	

	@Bean
	 public Step step2(StepBuilderFactory stepBuilderFactory) {
	return stepBuilderFactory.get("step2").<UserDto, UserDto> chunk(2)
	    .reader(userReaderDbImpl.reader())
	    .processor(new UserProcessorImpl())
	    .writer(userWriterToCsvImpl.write(fileoutputPath))
	    .build();
	 }

	/**
	 * Write.
	 *
	 * @return the user writer impl
	 */
	@Bean
	public UserWriterImpl write() {
		logger.info("< Début BatchUserConfig.UserWriterImpl");
		return new UserWriterImpl();
	}

	/**
	 * Read.
	 *
	 * @return the flat file item reader
	 */
	@Bean
	public FlatFileItemReader<UserDto> read() {
		logger.info("< Début BatchUserConfig.FlatFileItemReader");
		return new UserReaderImpl().reader(userInJobHeader, fileInputPath);
		
	}
	@Bean
	public RepositoryAcountDTO getAcountDTORepository(){
		return new RepositoryAcountDTO();
	}
	
	
}
