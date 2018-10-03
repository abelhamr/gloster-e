package ma.gloster.microservice.business;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import ma.gloster.microservice.repository.UserRepository;
import ma.gloster.microservice.repository.entity.UserEntity;

/**
 * The Class UserBusinessImpTest.
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
@PropertySource("classpath:application.properties")
public class UserBusinessImpTest {

	/** The user repository. */
	@Mock
	private UserRepository userRepository;
	
	/**
	 * Update user test.
	 */
	@Test
	public void updateUserTest() {
		UserEntity user1 = new UserEntity("addressTest", "statusTest", "emailTest");
		//this.userRepository.save(user1);
		this.userRepository.updateUser("addressTestUpdate", "addressTestUpdate", "emailTest");

		UserEntity user2 = new UserEntity("addressTestUpdate", "statusTestUpdate", "emailTest");

		when(userRepository.findAll()).thenReturn(Arrays.asList(user2));

		java.util.List<UserEntity> users = this.userRepository.findAll();
		for (UserEntity user : users) {
			assertNotEquals(user1.getAdress(), user.getAdress());
		}

	}

	/**
	 * Authenticate user test.
	 */
	@Test
	public void authenticateUserTest() {
		IUserBusiness userbusiness = mock(IUserBusiness.class);
		when(userbusiness.authenticateUser("batch@devops.com", "123")).thenReturn(true);
	}

}