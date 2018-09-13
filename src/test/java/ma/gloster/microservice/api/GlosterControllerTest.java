package ma.gloster.microservice.api;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;

/**
 * 
 * The Class GlosterControllerTest.
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
@PropertySource("classpath:application.properties")
public class GlosterControllerTest {

	/** The rest template. */
	@Mock
	private TestRestTemplate restTemplate;

	/**
	 * Perform user in job test.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void performUserInJobTest() throws Exception {
		String body = this.restTemplate.postForObject("/userInJobRequest/batch@devops.com/123", String.class,
				String.class);
		when(body).thenReturn("userInJob en execution...");
	}

}