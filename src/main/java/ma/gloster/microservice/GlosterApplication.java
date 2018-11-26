package ma.gloster.microservice;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ma.gloster.microservice.business.IUserBusiness;
import ma.gloster.microservice.business.UserBusinessImpl;
import ma.gloster.microservice.exception.ApplicationException;
import ma.gloster.microservice.repository.entity.UserEntity;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * The Class GlosterApplication.
 */
@EnableBatchProcessing
@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories

public class GlosterApplication {

	@Autowired(required = true)
	public JobLauncher jobLauncher;

	@Autowired
	@Qualifier("userInJob")
	public Job usersInJob;
	
	@Autowired
	@Qualifier("userOutJob")
	public Job userOutJob;
	

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(GlosterApplication.class);

	/**
	 * Perform user in job.
	 *
	 * @throws ApplicationException the application exception
	 */
	

	
//	@Scheduled(cron = "${spring.scheduler.userInJob}")
//	public void performUserInJob() throws ApplicationException {
//		
//		logger.info("< Début GlosterApplication.performUserInJob");
//		try {
//			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
//					.toJobParameters();
//			jobLauncher.run(usersInJob, jobParameters);
//		} catch (Exception e) {
//			logger.error(ApplicationException.getStackTrace(e));
//			throw new ApplicationException(e);
//		}
//		logger.info("> Fin GlosterApplication.performUserInJob");
//	
//	}
//	
//		@Scheduled(cron = "${spring.scheduler.userOutJob}")
//	public void performUserOutJob() throws ApplicationException {
//			System.out.println("Job2");
//		logger.info("< Début GlosterApplication.performUserInJob");
//		try {
//			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
//					.toJobParameters();
//			jobLauncher.run(userOutJob, jobParameters);
//		} catch (Exception e) {
//			logger.error(ApplicationException.getStackTrace(e));
//			throw new ApplicationException(e);
//		}
//		logger.info("> Fin GlosterApplication.performUserInJob");
//	
//	}
	public static void main(String[] args) {
		
		logger.info("< Démarage de l'application");
		SpringApplication.run(GlosterApplication.class, args);
		logger.info("> Arrêt de l'application");
		

	}

}
