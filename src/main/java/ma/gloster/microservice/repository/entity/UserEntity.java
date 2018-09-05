package ma.gloster.microservice.repository.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class UserEntity.
 */
@Entity
@Table(name = "USER_TABLE")
public class UserEntity {

	/** The id user. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USER")
	private Long idUser;

	/** The nom. */
	@Column(name = "NOM")
	private String nom;

	/** The prenom. */
	@Column(name = "PRENOM")
	private String prenom;

	/** The matricule. */
	@Column(name = "MATRICULE")
	private String matricule;

	/** The email. */
	@Column(name = "EMAIL")
	private String email;

	/** The cin. */
	@Column(name = "CIN")
	private String cin;

	/** The adress. */
	@Column(name = "ADDRESS")
	private String adress;

	/** The statut. */
	@Column(name = "STATUT")
	private String statut;

	/** The date creation. */
	@Column(name = "DATE_CREATION")
	private Date dateCreation;

	/** The date dernier connexion. */
	@Column(name = "DATE_DERNIERCONNEXION")
	private Date dateDernierConnexion;

	/** The id profil. */
	@Column(name = "ID_PROFIL")
	private Long idProfil;

	/** The id code exploitant. */
	@Column(name = "ID_CODEEXPLOITANT")
	private Long idCodeExploitant;

	/** The agence id. */
	@Column(name = "AGENCE_ID")
	private Long agenceId;

	/** The num compte. */
	@Column(name = "NUMCOMPTE")
	private String numCompte;

	/**
	 * Instantiates a new user entity.
	 */
	public UserEntity() {
		super();
	}

	/**
	 * Gets the id user.
	 *
	 * @return the id user
	 */
	public Long getIdUser() {
		return idUser;
	}

	/**
	 * Sets the id user.
	 *
	 * @param idUser
	 *            the new id user
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Gets the prenom.
	 *
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Sets the prenom.
	 *
	 * @param prenom
	 *            the new prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Gets the matricule.
	 *
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Sets the matricule.
	 *
	 * @param matricule
	 *            the new matricule
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
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
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the cin.
	 *
	 * @return the cin
	 */
	public String getCin() {
		return cin;
	}

	/**
	 * Sets the cin.
	 *
	 * @param cin
	 *            the new cin
	 */
	public void setCin(String cin) {
		this.cin = cin;
	}

	/**
	 * Gets the adress.
	 *
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * Sets the adress.
	 *
	 * @param adress
	 *            the new adress
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * Gets the statut.
	 *
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * Sets the statut.
	 *
	 * @param statut
	 *            the new statut
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

	/**
	 * Gets the date creation.
	 *
	 * @return the date creation
	 */
	public Date getDateCreation() {
		return dateCreation;
	}

	/**
	 * Sets the date creation.
	 *
	 * @param dateCreation
	 *            the new date creation
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * Gets the date dernier connexion.
	 *
	 * @return the date dernier connexion
	 */
	public Date getDateDernierConnexion() {
		return dateDernierConnexion;
	}

	/**
	 * Sets the date dernier connexion.
	 *
	 * @param dateDernierConnexion
	 *            the new date dernier connexion
	 */
	public void setDateDernierConnexion(Date dateDernierConnexion) {
		this.dateDernierConnexion = dateDernierConnexion;
	}

	/**
	 * Gets the id profil.
	 *
	 * @return the id profil
	 */
	public Long getIdProfil() {
		return idProfil;
	}

	/**
	 * Sets the id profil.
	 *
	 * @param idProfil
	 *            the new id profil
	 */
	public void setIdProfil(Long idProfil) {
		this.idProfil = idProfil;
	}

	/**
	 * Gets the id code exploitant.
	 *
	 * @return the id code exploitant
	 */
	public Long getIdCodeExploitant() {
		return idCodeExploitant;
	}

	/**
	 * Sets the id code exploitant.
	 *
	 * @param idCodeExploitant
	 *            the new id code exploitant
	 */
	public void setIdCodeExploitant(Long idCodeExploitant) {
		this.idCodeExploitant = idCodeExploitant;
	}

	/**
	 * Gets the agence id.
	 *
	 * @return the agence id
	 */
	public Long getAgenceId() {
		return agenceId;
	}

	/**
	 * Sets the agence id.
	 *
	 * @param agenceId
	 *            the new agence id
	 */
	public void setAgenceId(Long agenceId) {
		this.agenceId = agenceId;
	}

	/**
	 * Gets the num compte.
	 *
	 * @return the num compte
	 */
	public String getNumCompte() {
		return numCompte;
	}

	/**
	 * Sets the num compte.
	 *
	 * @param numCompte
	 *            the new num compte
	 */
	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom
	 *            the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}