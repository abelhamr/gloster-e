package ma.gloster.microservice.api;

import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.gloster.microservice.business.IUserBusiness;
import ma.gloster.microservice.exception.ApplicationException;
import ma.gloster.microservice.exception.BusinessException;

/**
 * The Class UserJobLauncherController. this class allow us to consume the batch
 * via http request
 */
@RestController
public class GlosterController {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(GlosterController.class);

	/**
	 * The message.
	 */
	private ResourceBundle message = ResourceBundle.getBundle("message");

	/** The job launcher. */
	@Autowired(required = true)
	private JobLauncher jobLauncher;

	/** The users in job. */
	@Autowired
	private Job usersInJob;

	/** The user business. */
	@Autowired
	private IUserBusiness userBusiness;

	/**
	 * Gets the batch with get req.
	 *
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 * @return the batch with get request
	 * @throws ApplicationException
	 *             the application exception
	 * @throws JobExecutionAlreadyRunningException
	 *             the job execution already running exception
	 * @throws JobRestartException
	 *             the job restart exception
	 * @throws JobInstanceAlreadyCompleteException
	 *             the job instance already complete exception
	 * @throws JobParametersInvalidException
	 *             the job parameters invalid exception
	 */
	@CrossOrigin
	@PostMapping("/userInJobRequest/{login}/{password}")
	public ResponseEntity<String> performUserInJob(@PathVariable("login") String login,
			@PathVariable("password") String password) throws ApplicationException, JobExecutionAlreadyRunningException,
			JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {

		logger.info("< Démarage de la fonction performUserInJob");
		ResponseEntity<String> responseEntity = null;
		try {

			if (userBusiness.authenticateUser(login, password)) {

				JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
						.toJobParameters();
				jobLauncher.run(usersInJob, jobParameters);

				responseEntity = new ResponseEntity<>(
						this.message.getString("spring.controller.response.userInJob.executing"), HttpStatus.OK);
			} else {
				throw new ApplicationException(
						this.message.getString("spring.controller.response.error.authentication"));

			}

		} catch (BusinessException e) {
			logger.error(ApplicationException.getStackTrace(e));
			throw new ApplicationException(this.message.getString("spring.controller.response.error.intern"));
		}

		logger.info("> Fin de la fonction performUserInJob");

		return responseEntity;
	}

}