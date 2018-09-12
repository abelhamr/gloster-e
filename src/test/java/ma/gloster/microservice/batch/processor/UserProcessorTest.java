package ma.gloster.microservice.batch.processor;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ma.gloster.microservice.dto.UserDto;


@SpringBootTest
//@RunWith(MockitoJUnitRunner.Silent.class) 
@RunWith(SpringRunner.class)
public class UserProcessorTest {
	
	@Test
	public void processTest() throws Exception{
		UserProcessorImpl userProcessorImpl = new UserProcessorImpl();
		assertNotNull(userProcessorImpl.process(new UserDto()));
	}

}
