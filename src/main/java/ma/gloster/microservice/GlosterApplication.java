package ma.gloster.microservice;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ma.gloster.microservice.exception.ApplicationException;
import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Class GlosterApplication.
 */
@EnableBatchProcessing
@SpringBootApplication
@EnableScheduling
public class GlosterApplication {
	
	@Autowired(required = true)
	public JobLauncher jobLauncher;

	@Autowired
	public Job usersInJob;

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(GlosterApplication.class);

	@Scheduled(cron = "${spring.scheduler.userInJob}")
	public void performUserInJob() throws ApplicationException {
		try {
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
					.toJobParameters();
			jobLauncher.run(usersInJob, jobParameters);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		logger.info("< Démarage de l'application");
		SpringApplication.run(GlosterApplication.class, args);
		logger.info("> Arrêt de l'application");

	}

}
