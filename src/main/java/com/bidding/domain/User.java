package com.bidding.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author Krishna User domain class to store user information including
 *         username, email, password and so forth.
 *
 */

@Entity
@Table(name = "user")
public class User {
	/**
	 * id - this property stores user id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * userName - this property stores the user name of a user
	 */
	@NotEmpty
	@Size(min = 4, max = 15, message = "{user.username.size}")
	private String userName;
	/**
	 * userPassword - this property stores password for a User
	 */
	@NotEmpty
	@Size(min = 6, message = "{user.password.size}")
	private String userPassword;
	/**
	 * userEmail - this property stores email of a User.
	 */
	@NotEmpty
	@Email(message = "user.message.email")
	private String userEmail;
	/**
	 * userRole - this property stores user Role of a User
	 */
	@NotEmpty
	private String userRole;
	/**
	 * products - this property stores list of products of a User
	 */
	@OneToMany(mappedBy = "user")
	private List<Product> products;

	/**
	 * bidDetails - this property stores the list of bids made by User
	 */
	@OneToMany(mappedBy = "user")
	private List<Bid> bidDetails;

	/**
	 * Default constructor for User domain Class
	 */
	public User() {

	}

	/**
	 * Method to return the list of the products added by User
	 * 
	 * @return products - products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * Method to return bids made by User
	 * 
	 * @return bidDetails - bid details
	 */
	public List<Bid> getBidDetails() {
		return bidDetails;
	}

	/**
	 * Method to set the bid for a product
	 * 
	 * @param bidDetails
	 *            - list of bids made by User
	 */
	public void setBidDetails(List<Bid> bidDetails) {
		this.bidDetails = bidDetails;
	}

	/**
	 * Method to set the products added by the User
	 * 
	 * @param products
	 *            - list of products
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * Method to return the user Id
	 * 
	 * @return id - user id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Method to set User Id
	 * 
	 * @param id
	 *            - User Id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Method to return username of the User
	 * 
	 * @return userName - username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Method to set username of the User
	 * 
	 * @param userName
	 *            - userName of the User
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Method to return password of the User
	 * 
	 * @return userPassword - user password
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * Method to set password of the user
	 * 
	 * @param userPassword
	 *            - user password
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * Method to return email of the user
	 * 
	 * @return userName - user email
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * Method to set email of the user
	 * 
	 * @param userEmail
	 *            - user email
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * Method to return user role
	 * 
	 * @return userRole - userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * Method to set role of the user
	 * 
	 * @param userRole
	 *            - user role
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
