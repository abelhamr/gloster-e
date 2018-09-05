package ma.gloster.microservice.dto;

/**
 * The Class UserDto.
 */
public class UserDto {

	/** The user id. */
	private int userId;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The registration number. */
	private String registrationNumber;

	/** The mail. */
	private String email;

	/** The address. */
	private String address;

	/** The agency id. */
	private int agencyId;

	/** The account number. */
	private String accountNumber;

	/** The status. */
	private String status;

	/**
	 * Instantiates a new user dto.
	 */
	public UserDto() {
		super();
	}

	/**
	 * Instantiates a new user dto.
	 *
	 * @param add the add
	 * @param email the email
	 * @param status the status
	 */
	public UserDto(String add, String email, String status) {
		this.address = add;
		this.email = email;
		this.status = status;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the registration number.
	 *
	 * @return the registration number
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * Sets the registration number.
	 *
	 * @param registrationNumber the new registration number
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the agency id.
	 *
	 * @return the agency id
	 */
	public int getAgencyId() {
		return agencyId;
	}

	/**
	 * Sets the agency id.
	 *
	 * @param agencyId the new agency id
	 */
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	/**
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Sets the account number.
	 *
	 * @param accountNumber the new account number
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
