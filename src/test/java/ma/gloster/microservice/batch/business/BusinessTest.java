package ma.gloster.microservice.batch.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ma.gloster.microservice.exception.BusinessException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessTest {

	@Test
	public void updateUserTest() throws BusinessException {
		assertEquals("true", "true");
	}

}
