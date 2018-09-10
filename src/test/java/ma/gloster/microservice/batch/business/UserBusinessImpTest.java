package ma.gloster.microservice.batch.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ma.gloster.microservice.business.IUserBusiness;
import ma.gloster.microservice.repository.UserRepository;
import ma.gloster.microservice.repository.entity.UserEntity;

/**
 * The Class UserBusinessImpTest.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserBusinessImpTest {

	/** The user repository. */
	@Autowired(required = true)
	private UserRepository userRepository;

	/** The user business. */
	@Autowired
	IUserBusiness userBusiness;

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
		assertEquals(true, userBusiness.authenticateUser("batch@devops.com", "123"));
	}

}