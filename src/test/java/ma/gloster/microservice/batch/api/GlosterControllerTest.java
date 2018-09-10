package ma.gloster.microservice.batch.api;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

// TODO: Auto-generated Javadoc
/**
 * The Class GlosterControllerTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GlosterControllerTest {

	/** The rest template. */
	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * Perform user in job test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void performUserInJobTest() throws Exception {
		String body = this.restTemplate.postForObject("/userInJobRequest/batch@devops.com/123", String.class,
				String.class);
		assertThat(body).isEqualTo("userInJob en execution...");
	}

}