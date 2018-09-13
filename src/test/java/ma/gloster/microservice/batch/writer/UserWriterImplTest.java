package ma.gloster.microservice.batch.writer;

import static org.mockito.Mockito.doNothing;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import ma.gloster.microservice.business.UserBusinessImpl;
import ma.gloster.microservice.dto.UserDto;
import ma.gloster.microservice.exception.BusinessException;


/**
 * The Class UserWriterImplTest.
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
@PropertySource("classpath:application.properties")
public class UserWriterImplTest {

	/** The user writer impl. */
	@Mock
	private UserWriterImpl userWriterImpl;

	/** The user business. */
	@InjectMocks
	private UserBusinessImpl userBusiness;

	/** The liste. */
	private List<UserDto> liste;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		UserDto userDto1 = new UserDto();
		UserDto userDto2 = new UserDto();

		liste = new ArrayList<>();

		liste.add(userDto1);
		liste.add(userDto2);

	}

	/**
	 * Write test.
	 *
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void writeTest() throws BusinessException {

		doNothing().when(userWriterImpl).write(liste);

	}

}
