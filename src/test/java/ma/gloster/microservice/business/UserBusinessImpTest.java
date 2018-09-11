package ma.gloster.microservice.business;

import static org.junit.Assert.assertNotEquals;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import ma.gloster.microservice.business.IUserBusiness;
import ma.gloster.microservice.repository.UserRepository;
import ma.gloster.microservice.repository.entity.UserEntity;
import static org.mockito.Mockito.*;

/**
 * The Class UserBusinessImpTest.
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class) 
public class UserBusinessImpTest {

	/** The user repository. */
	@Mock
	private UserRepository userRepository;

	/**
	 * Update user test.
	 */
	@Test
	public void updateUserTest() {
		UserEntity user1 = new UserEntity("addresstest", "statustest", "emailtest");
		this.userRepository.save(user1);
		this.userRepository.updateUser("addresstestupdate", "addresstestupdate", "emailtestupdate");
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