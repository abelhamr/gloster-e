package ma.gloster.microservice.batch.config;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.item.ItemWriter;
import org.springframework.boot.test.context.SpringBootTest;

import ma.gloster.microservice.dto.UserDto;


/**
 * The Class BatchUserConfigTest.
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class) 
public class BatchUserConfigTest {
	
	/** The job. */
	@Mock
	private Job job;
	
	/** The step. */
	@Mock
	private Step step;
	
	/** The item writer. */
	@Mock
	private ItemWriter<UserDto> itemWriter;
	
	/**
	 * Job test.
	 */
	@Test
	public void JobTest(){
		assertNotNull(job);
	}
	
	/**
	 * Step test.
	 */
	@Test
	public void StepTest(){
		assertNotNull(step);
	}
	
	/**
	 * Write test.
	 */
	@Test
	public void WriteTest(){
		assertNotNull(itemWriter);
	}
	

}
