package ma.gloster.microservice.exception;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;

/**
 * The Class ApplicationExceptionTest.
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
@PropertySource("classpath:application.properties")
public class ApplicationExceptionTest {
	
	@Mock
	private TestRestTemplate restTemplate;
	
	/**
	 * Perform user in job with exception test.
	 */
	@Test
	public void performUserInJobWithExceptionTest(){
		ApplicationException body = this.restTemplate.postForObject("/userInJobRequest/batch@devops.com/1232", String.class,
				ApplicationException.class);
		when(body).thenReturn(new ApplicationException());
	}

}
